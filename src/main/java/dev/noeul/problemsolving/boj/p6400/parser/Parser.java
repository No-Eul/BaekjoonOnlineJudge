package dev.noeul.problemsolving.boj.p6400.parser;

import dev.noeul.problemsolving.boj.p6400.SyntaxException;
import dev.noeul.problemsolving.boj.p6400.lexer.EndOfFileToken;
import dev.noeul.problemsolving.boj.p6400.lexer.EndOfLineToken;
import dev.noeul.problemsolving.boj.p6400.lexer.IdentifierToken;
import dev.noeul.problemsolving.boj.p6400.lexer.NumericLiteralToken;
import dev.noeul.problemsolving.boj.p6400.lexer.PunctuationToken;
import dev.noeul.problemsolving.boj.p6400.lexer.Token;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Parser {
	private final Token[] tokens;
	private int pos;

	public Parser(Collection<Token> tokens) {
		this.tokens = tokens.toArray(new Token[0]);
	}

	public Program parse() {
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
		return new Program(statements);
	}

	private Statement parseStatement() {
		Statement statement = this.parseAssignmentStatement();
		Token token = this.read();
		if (!token.equals(EndOfLineToken.EOL) && !token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedToken();
		return statement;
	}

	private Assignment parseAssignmentStatement() {
		Optional<Character> optional = this.parseVariableName();
		if (!optional.isPresent())
			throw Parser.unexpectedToken();
		Token token = this.read();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(PunctuationToken.EQ))
			throw Parser.unexpectedToken();
		return new Assignment(optional.get(), this.parseExpression());
	}

	private Expression parseExpression() {
		return this.parseAssignmentExpression();
	}

	private Expression parseAssignmentExpression() {
		int start = this.pos;
		Optional<Character> optional = this.parseVariableName();
		if (!optional.isPresent())
			return this.parseBinaryOperation();
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(PunctuationToken.EQ)) {
			this.pos = start;
			return this.parseBinaryOperation();
		}
		this.skip();
		return new Assignment(optional.get(), this.parseAssignmentExpression());
	}

	private Expression parseBinaryOperation() {
		Expression operand = this.parseNegationOperation();
		loop:
		while (this.canRead()) {
			for (BinaryOperation.Operator operator : BinaryOperation.Operator.values()) {
				if (this.peek().equals(operator.token)) {
					this.skip();
					operand = new BinaryOperation(operator, operand, this.parseBinaryOperation());
					continue loop;
				}
			}
			break;
		}
		return operand;
	}

	private Expression parseNegationOperation() {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(PunctuationToken.LOWLINE))
			return this.parseOperand();
		this.skip();
		return new NegationOperation(this.parseNegationOperation());
	}

	private Expression parseOperand() {
		Optional<? extends Expression> optional = this.parseNumber();
		if (!optional.isPresent())
			optional = this.parseVariable();
		if (!optional.isPresent())
			optional = this.parseWrappedExpression();
		return optional.orElseThrow(Parser::unexpectedToken);
	}

	private Optional<Number> parseNumber() {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!(token instanceof NumericLiteralToken))
			return Optional.empty();
		this.skip();
		return Optional.of(new Number(Integer.parseInt(token.getValue())));
	}

	private Optional<Variable> parseVariable() {
		return this.parseVariableName().map(Variable::new);
	}

	private Optional<Character> parseVariableName() {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!(token instanceof IdentifierToken))
			return Optional.empty();
		this.skip();
		return Optional.of(token.getValue().charAt(0));
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

	public boolean canRead() {
		return this.pos < this.tokens.length;
	}

	public Token read() {
		return this.tokens[this.pos++];
	}

	public Token peek() {
		return this.tokens[this.pos];
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
