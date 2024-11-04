package dev.noeul.problemsolving.boj.p11516.parser;

import dev.noeul.problemsolving.boj.p11516.SyntaxException;
import dev.noeul.problemsolving.boj.p11516.lexer.EndOfFileToken;
import dev.noeul.problemsolving.boj.p11516.lexer.EndOfLineToken;
import dev.noeul.problemsolving.boj.p11516.lexer.IdentifierToken;
import dev.noeul.problemsolving.boj.p11516.lexer.KeywordToken;
import dev.noeul.problemsolving.boj.p11516.lexer.NumberLiteralToken;
import dev.noeul.problemsolving.boj.p11516.lexer.PunctuationToken;
import dev.noeul.problemsolving.boj.p11516.lexer.Token;
import dev.noeul.problemsolving.boj.p11516.parser.expression.NumericExpression;
import dev.noeul.problemsolving.boj.p11516.parser.expression.OperationExpression;
import dev.noeul.problemsolving.boj.p11516.parser.expression.VariableExpression;
import dev.noeul.problemsolving.boj.p11516.parser.statement.AssignmentStatement;
import dev.noeul.problemsolving.boj.p11516.parser.statement.IfStatement;
import dev.noeul.problemsolving.boj.p11516.parser.statement.PrintStatement;
import dev.noeul.problemsolving.boj.p11516.parser.statement.ProgramStatement;
import dev.noeul.problemsolving.boj.p11516.parser.statement.WhileStatement;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Parser {
	private final List<Token> tokens;
	private int index;

	public Parser(List<Token> tokens) {
		this.tokens = tokens;
	}

	public SyntaxTree parse() throws SyntaxException {
		List<StatementNode> statements = new LinkedList<>();
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

	public List<StatementNode> parseStatements(Predicate<Token> terminator) throws SyntaxException {
		List<StatementNode> statements = new LinkedList<>();
		while (this.canRead()) {
			Token token = this.peek();
			if (token.equals(EndOfFileToken.EOF))
				throw Parser.unexpectedEOF();
			if (token.equals(EndOfLineToken.EOL)) {
				this.skip();
				continue;
			}
			if (terminator.test(token))
				break;
			statements.add(this.parseStatement());
		}
		return statements;
	}

	public StatementNode parseStatement() throws SyntaxException {
		Optional<StatementNode> optional = this.parseIfStatement();
		if (!optional.isPresent())
			optional = this.parseWhileStatement();
		if (!optional.isPresent())
			optional = this.parseAssignmentStatement();
		if (!optional.isPresent())
			optional = this.parsePrintStatement();
		StatementNode statement = optional.orElseThrow(Parser::unexpectedToken);
		Token token = this.peek();
		if (!token.equals(EndOfFileToken.EOF) && !token.equals(EndOfLineToken.EOL))
			throw Parser.unexpectedToken();
		this.skip();
		return statement;
	}

	public Optional<StatementNode> parseIfStatement() throws SyntaxException {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(KeywordToken.IF))
			return Optional.empty();
		this.skip();

		ExpressionNode expression = this.parseExpression();

		token = this.read();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(EndOfLineToken.EOL))
			throw Parser.unexpectedToken();

		List<StatementNode> statementsIfTrue = this.parseStatements(
				token1 -> token1.equals(KeywordToken.END) || token1.equals(KeywordToken.ELSE)
		);

		token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		Optional<List<StatementNode>> statementsIfFalse = Optional.empty();
		if (token.equals(KeywordToken.ELSE)) {
			this.skip();
			token = this.read();
			if (token.equals(EndOfFileToken.EOF))
				throw Parser.unexpectedEOF();
			if (!token.equals(EndOfLineToken.EOL))
				throw Parser.unexpectedToken();

			statementsIfFalse = Optional.ofNullable(this.parseStatements(token1 -> token1.equals(KeywordToken.END)));
		}

		token = this.read();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(KeywordToken.END))
			throw Parser.unexpectedToken();

		token = this.read();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(KeywordToken.IF))
			throw Parser.unexpectedToken();

		return Optional.of(new IfStatement(expression, statementsIfTrue, statementsIfFalse));
	}

	public Optional<StatementNode> parseWhileStatement() throws SyntaxException {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(KeywordToken.WHILE))
			return Optional.empty();
		this.skip();

		ExpressionNode expression = this.parseExpression();

		token = this.read();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(EndOfLineToken.EOL))
			throw Parser.unexpectedToken();

		List<StatementNode> statements = this.parseStatements(token1 -> token1.equals(KeywordToken.END));

		token = this.read();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(KeywordToken.END))
			throw Parser.unexpectedToken();

		token = this.read();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(KeywordToken.WHILE))
			throw Parser.unexpectedToken();

		return Optional.of(new WhileStatement(expression, statements));
	}

	public Optional<StatementNode> parseAssignmentStatement() throws SyntaxException {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(KeywordToken.SET))
			return Optional.empty();
		this.skip();

		Optional<String> variable = this.parseVariableName();
		if (!variable.isPresent())
			throw Parser.unexpectedToken();

		token = this.read();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(PunctuationToken.EQ))
			throw Parser.unexpectedToken();

		return Optional.of(new AssignmentStatement(variable.get(), this.parseExpression()));
	}

	public Optional<StatementNode> parsePrintStatement() throws SyntaxException {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(KeywordToken.PRINT))
			return Optional.empty();
		this.skip();
		return Optional.of(new PrintStatement(this.parseExpression()));
	}

	public ExpressionNode parseExpression() throws SyntaxException {
		return this.parseLogicalOperation();
	}

	public ExpressionNode parseLogicalOperation() throws SyntaxException {
		return this.parseBinaryOperation(
				() -> this.parseBinaryOperation(
						this::parseEqualityOperation,
						OperationExpression.Operator.AND
				),
				OperationExpression.Operator.OR
		);
	}

	public ExpressionNode parseEqualityOperation() throws SyntaxException {
		return this.parseBinaryOperation(
				this::parseRelationalOperation,
				OperationExpression.Operator.EQUALITY,
				OperationExpression.Operator.INEQUALITY
		);
	}

	public ExpressionNode parseRelationalOperation() throws SyntaxException {
		return this.parseBinaryOperation(
				this::parseAdditiveOperation,
				OperationExpression.Operator.LESS_THAN,
				OperationExpression.Operator.LESS_THAN_OR_EQUAL,
				OperationExpression.Operator.GREATER_THAN,
				OperationExpression.Operator.GREATER_THAN_OR_EQUAL
		);
	}

	public ExpressionNode parseAdditiveOperation() throws SyntaxException {
		return this.parseBinaryOperation(
				this::parseMultiplicativeOperation,
				OperationExpression.Operator.ADDITION,
				OperationExpression.Operator.SUBTRACTION
		);
	}

	public ExpressionNode parseMultiplicativeOperation() throws SyntaxException {
		return this.parseBinaryOperation(
				this::parseUnaryOperation,
				OperationExpression.Operator.MULTIPLICATION,
				OperationExpression.Operator.DIVISION,
				OperationExpression.Operator.REMAINDER
		);
	}

	@SuppressWarnings("ClassEscapesDefinedScope")
	public ExpressionNode parseBinaryOperation(
			OperationParser precedenceOperand,
			OperationExpression.Operator... operators
	) throws SyntaxException {
		ExpressionNode operand = precedenceOperand.parseOperation();

		loop:
		while (this.canRead()) {
			for (OperationExpression.Operator operator : operators) {
				if (this.peek().equals(operator.token)) {
					this.skip();
					operand = new OperationExpression(operator, operand, precedenceOperand.parseOperation());
					continue loop;
				}
			}
			break;
		}

		return operand;
	}

	public ExpressionNode parseUnaryOperation() throws SyntaxException {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (token.equals(PunctuationToken.MINUS)) {
			this.skip();
			return new OperationExpression(OperationExpression.Operator.NEGATION, this.parseUnaryOperation());
		}
		if (token.equals(PunctuationToken.BANG)) {
			this.skip();
			return new OperationExpression(OperationExpression.Operator.LOGICAL_NEGATION, this.parseUnaryOperation());
		}
		return this.parseOperand();
	}

	public ExpressionNode parseOperand() throws SyntaxException {
		Optional<? extends ExpressionNode> optional = this.parseNumber();
		if (!optional.isPresent())
			optional = this.parseVariableName().map(VariableExpression::new);
		if (!optional.isPresent())
			optional = this.parseWrappedExpression();
		return optional.orElseThrow(Parser::unexpectedToken);
	}

	public Optional<NumericExpression> parseNumber() throws SyntaxException {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!(token instanceof NumberLiteralToken))
			return Optional.empty();
		this.skip();
		return Optional.of(new NumericExpression(Integer.parseInt(token.value())));
	}

	public Optional<String> parseVariableName() throws SyntaxException {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!(token instanceof IdentifierToken))
			return Optional.empty();
		this.skip();
		return Optional.of(token.value());
	}

	public Optional<ExpressionNode> parseWrappedExpression() throws SyntaxException {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(PunctuationToken.LPAREN))
			return Optional.empty();
		this.skip();
		ExpressionNode expression = this.parseExpression();
		token = this.read();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(PunctuationToken.RPAREN))
			throw Parser.unexpectedToken();
		return Optional.of(expression);
	}

	public boolean canRead() {
		return this.index < this.tokens.size();
	}

	public Token peek() {
		return this.tokens.get(this.index);
	}

	public Token read() {
		return this.tokens.get(this.index++);
	}

	public void skip() {
		this.index++;
	}

	public static SyntaxException unexpectedEOF() {
		return new SyntaxException("Unexpected end of file");
	}

	public static SyntaxException unexpectedToken() {
		return new SyntaxException("Unexpected token");
	}

	private interface OperationParser {
		ExpressionNode parseOperation() throws SyntaxException;
	}
}
