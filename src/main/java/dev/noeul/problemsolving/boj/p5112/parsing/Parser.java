package dev.noeul.problemsolving.boj.p5112.parsing;

import dev.noeul.problemsolving.boj.p5112.SyntaxException;
import dev.noeul.problemsolving.boj.p5112.interpreter.Function;
import dev.noeul.problemsolving.boj.p5112.lexing.EndOfFileToken;
import dev.noeul.problemsolving.boj.p5112.lexing.EndOfLineToken;
import dev.noeul.problemsolving.boj.p5112.lexing.IdentifierToken;
import dev.noeul.problemsolving.boj.p5112.lexing.KeywordToken;
import dev.noeul.problemsolving.boj.p5112.lexing.NumericLiteralToken;
import dev.noeul.problemsolving.boj.p5112.lexing.PunctuationToken;
import dev.noeul.problemsolving.boj.p5112.lexing.Token;
import dev.noeul.problemsolving.boj.p5112.parsing.expressions.ArithmeticOperationExpression;
import dev.noeul.problemsolving.boj.p5112.parsing.expressions.FunctionCallExpression;
import dev.noeul.problemsolving.boj.p5112.parsing.expressions.NumberExpression;
import dev.noeul.problemsolving.boj.p5112.parsing.expressions.VariableReferenceExpression;
import dev.noeul.problemsolving.boj.p5112.parsing.statements.ExpressionStatement;
import dev.noeul.problemsolving.boj.p5112.parsing.statements.FunctionDeclarationStatement;
import dev.noeul.problemsolving.boj.p5112.parsing.statements.ProfilingStatement;
import dev.noeul.problemsolving.boj.p5112.parsing.statements.ProgramEndStatement;
import dev.noeul.problemsolving.boj.p5112.parsing.statements.ProgramStatement;
import dev.noeul.problemsolving.boj.p5112.parsing.statements.VariableDeclarationStatement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Parser {
	private final Token[] tokens;
	private int pos;

	public Parser(Token[] tokens) {
		this.tokens = tokens;
	}

	// Statements Part

	public ProgramStatement parse() {
		List<Statement> statements = new ArrayList<>();
		while (this.canRead()) {
			Token token = this.peek();
			if (token.equals(EndOfFileToken.EOF))
				break;
			if (token.equals(EndOfLineToken.EOL)) {
				this.skip();
				continue;
			}
			statements.add(this.parseStatement());
		}
		return new ProgramStatement(statements);
	}

	private Statement parseStatement() {
		Optional<? extends Statement> optional = this.parseFunctionDeclaration();
		if (!optional.isPresent())
			optional = this.parseVariableDeclaration();
		if (!optional.isPresent())
			optional = this.parseProfiling();
		if (!optional.isPresent())
			optional = this.parseProgramEnd();
		if (!optional.isPresent())
			optional = this.parseExpressionStatement();
		Statement statement = optional.orElseThrow(Parser::unexpectedToken);
		Token token = this.read();
		if (!token.equals(EndOfLineToken.EOL) && !token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedToken();
		return statement;
	}
	private Optional<FunctionDeclarationStatement> parseFunctionDeclaration() {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(KeywordToken.DEF))
			return Optional.empty();
		this.skip();
		String name = this.parseIdentifier().orElseThrow(Parser::unexpectedToken);
		if (!this.read().equals(PunctuationToken.LPAREN))
			throw Parser.unexpectedToken();
		Optional<Function.Parameter> optional = this.parseNumericLiteral()
				.map(Function.Parameter::new);
		if (!optional.isPresent())
			optional = this.parseIdentifier().map(Function.Parameter::new);
		Function.Parameter parameter = optional.orElseThrow(Parser::unexpectedToken);
		if (!this.read().equals(PunctuationToken.RPAREN))
			throw Parser.unexpectedToken();
		if (!this.read().equals(PunctuationToken.EQ))
			throw Parser.unexpectedToken();
		Expression expression = this.parseExpression();
		return Optional.of(new FunctionDeclarationStatement(name, parameter, expression));
	}

	private Optional<VariableDeclarationStatement> parseVariableDeclaration() {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(KeywordToken.SET))
			return Optional.empty();
		this.skip();
		String name = this.parseIdentifier().orElseThrow(Parser::unexpectedToken);
		token = this.read();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(PunctuationToken.EQ))
			throw Parser.unexpectedToken();
		Expression expression = this.parseExpression();
		return Optional.of(new VariableDeclarationStatement(name, expression));
	}

	private Optional<ProfilingStatement> parseProfiling() {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(KeywordToken.PROFILE))
			return Optional.empty();
		this.skip();
		return Optional.of(new ProfilingStatement());
	}

	private Optional<ProgramEndStatement> parseProgramEnd() {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(KeywordToken.EXIT))
			return Optional.empty();
		this.skip();
		return Optional.of(new ProgramEndStatement());
	}

	private Optional<ExpressionStatement> parseExpressionStatement() {
		return Optional.of(new ExpressionStatement(this.parseExpression()));
	}


	// Expressions Part

	private Expression parseExpression() {
		return this.parseAdditiveOperation();
	}

	private Expression parseAdditiveOperation() {
		Expression operand = this.parseMultiplicativeOperation();
		while (this.canRead()) {
			Token token = this.peek();
			if (token.equals(PunctuationToken.PLUS)) {
				this.skip();
				operand = new ArithmeticOperationExpression(
						ArithmeticOperationExpression.Operator.ADDITION,
						operand,
						this.parseMultiplicativeOperation()
				);
			} else if (token.equals(PunctuationToken.MINUS)) {
				this.skip();
				operand = new ArithmeticOperationExpression(
						ArithmeticOperationExpression.Operator.SUBTRACTION,
						operand,
						this.parseMultiplicativeOperation()
				);
			} else break;
		}
		return operand;
	}

	private Expression parseMultiplicativeOperation() {
		Expression operand = this.parseOperand();
		while (this.canRead()) {
			Token token = this.peek();
			if (token.equals(PunctuationToken.ASTERISK)) {
				this.skip();
				operand = new ArithmeticOperationExpression(
						ArithmeticOperationExpression.Operator.MULTIPLICATION,
						operand,
						this.parseOperand()
				);
			} else if (token.equals(PunctuationToken.SLASH)) {
				this.skip();
				operand = new ArithmeticOperationExpression(
						ArithmeticOperationExpression.Operator.DIVISION,
						operand,
						this.parseOperand()
				);
			} else if (token.equals(PunctuationToken.PERCENT)) {
				this.skip();
				operand = new ArithmeticOperationExpression(
						ArithmeticOperationExpression.Operator.REMAINDER,
						operand,
						this.parseOperand()
				);
			} else break;
		}
		return operand;
	}

	private Expression parseOperand() {
		Optional<? extends Expression> optional = this.parseNumber();
		if (!optional.isPresent())
			optional = this.parseFunctionCall();
		if (!optional.isPresent())
			optional = this.parseVariableReference();
		if (!optional.isPresent())
			optional = this.parseWrappedExpression();
		return optional.orElseThrow(Parser::unexpectedToken);
	}

	private Optional<NumberExpression> parseNumber() {
		return this.parseNumericLiteral().map(NumberExpression::new);
	}

	private Optional<VariableReferenceExpression> parseVariableReference() {
		return this.parseIdentifier().map(VariableReferenceExpression::new);
	}

	private Optional<FunctionCallExpression> parseFunctionCall() {
		int start = this.pos;
		Optional<String> name = this.parseIdentifier();
		if (!name.isPresent())
			return Optional.empty();
		Optional<Expression> expression = this.parseWrappedExpression();
		if (!expression.isPresent()) {
			this.pos = start;
			return Optional.empty();
		}
		return Optional.of(new FunctionCallExpression(name.get(), expression.get()));
	}

	private Optional<Expression> parseWrappedExpression() {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(PunctuationToken.LPAREN))
			return Optional.empty();
		this.skip();
		Expression expression = this.parseExpression();
		token = this.read();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(PunctuationToken.RPAREN))
			throw Parser.unexpectedToken();
		return Optional.of(expression);
	}

	// Miscellaneous Part

	private Optional<Integer> parseNumericLiteral() {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!(token instanceof NumericLiteralToken))
			return Optional.empty();
		this.skip();
		return Optional.of(Integer.parseInt(token.getValue()));
	}

	private Optional<String> parseIdentifier() {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!(token instanceof IdentifierToken))
			return Optional.empty();
		this.skip();
		return Optional.of(token.getValue());
	}

	// Internal Methods

	public boolean canRead() {
		return this.pos < this.tokens.length;
	}

	public Token peek() {
		return this.tokens[this.pos];
	}

	public Token read() {
		return this.tokens[this.pos++];
	}

	public void skip() {
		this.pos++;
	}

	public static SyntaxException unexpectedEOF() {
		return new SyntaxException("Unexpected end of file");
	}

	public static SyntaxException unexpectedToken() {
		return new SyntaxException("Unexpected token");
	}
}
