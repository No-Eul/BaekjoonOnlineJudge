package dev.noeul.problemsolving.boj.p3203.parser;

import dev.noeul.problemsolving.boj.p3203.SyntaxException;
import dev.noeul.problemsolving.boj.p3203.lexer.EndOfFileToken;
import dev.noeul.problemsolving.boj.p3203.lexer.EndOfLineToken;
import dev.noeul.problemsolving.boj.p3203.lexer.IdentifierToken;
import dev.noeul.problemsolving.boj.p3203.lexer.KeywordToken;
import dev.noeul.problemsolving.boj.p3203.lexer.NumberLiteralToken;
import dev.noeul.problemsolving.boj.p3203.lexer.PunctuationToken;
import dev.noeul.problemsolving.boj.p3203.lexer.Token;
import dev.noeul.problemsolving.boj.p3203.parser.expression.NumberExpression;
import dev.noeul.problemsolving.boj.p3203.parser.expression.OperationExpression;
import dev.noeul.problemsolving.boj.p3203.parser.expression.TermExpression;
import dev.noeul.problemsolving.boj.p3203.parser.statement.AssignmentStatement;
import dev.noeul.problemsolving.boj.p3203.parser.statement.PrintStatement;
import dev.noeul.problemsolving.boj.p3203.parser.statement.ProgramStatement;
import dev.noeul.problemsolving.boj.p3203.parser.statement.RepeatStatement;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Parser {
	private final List<Token> tokens;
	private int index;

	public Parser(List<Token> tokens) {
		this.tokens = tokens;
	}

	public SyntaxTree parse() throws SyntaxException {
		return this.parseProgramStatement();
	}

	public ProgramStatement parseProgramStatement() throws SyntaxException {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(KeywordToken.BEGIN))
			throw Parser.unexpectedToken();
		this.skip();
		token = this.peek();
		if (!token.equals(EndOfLineToken.EOL))
			throw Parser.unexpectedToken();
		this.skip();

		return new ProgramStatement(this.parseStatements());
	}

	public List<StatementNode> parseStatements() throws SyntaxException {
		List<StatementNode> statements = new LinkedList<>();
		while (true) {
			Token token = this.peek();
			if (token.equals(EndOfFileToken.EOF))
				throw Parser.unexpectedEOF();
			if (token.equals(KeywordToken.STOP)) {
				this.skip();
				break;
			}
			statements.add(this.parseStatement());
		}
		return statements;
	}

	public StatementNode parseStatement() throws SyntaxException {
		Optional<StatementNode> statement = this.parseAssignmentStatement();
		if (!statement.isPresent())
			statement = this.parseRepeatStatement();
		if (!statement.isPresent())
			statement = this.parsePrintStatement();
		if (!statement.isPresent())
			throw Parser.unexpectedToken();

		Token token = this.peek();
		if (!token.equals(EndOfLineToken.EOL))
			throw Parser.unexpectedToken();
		this.skip();

		return statement.get();
	}

	public Optional<StatementNode> parseAssignmentStatement() throws SyntaxException {
		Optional<VariableNode> variable = this.parseVariable();
		if (!variable.isPresent())
			return Optional.empty();

		Token token = this.read();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(PunctuationToken.EQ))
			throw Parser.unexpectedToken();

		ExpressionNode expression = this.parseExpression();

		return Optional.of(new AssignmentStatement(variable.get(), expression));
	}

	public ExpressionNode parseExpression() throws SyntaxException {
		ExpressionNode term = this.parseExpressionTerm();

		while (this.canRead()) {
			Token token = this.peek();
			if (token.equals(EndOfFileToken.EOF))
				throw Parser.unexpectedEOF();
			if (token.equals(PunctuationToken.PLUS)) {
				this.skip();
				term = new OperationExpression(OperationExpression.Operator.ADDITION, term, this.parseExpressionTerm());
				continue;
			}
			if (token.equals(PunctuationToken.MINUS)) {
				this.skip();
				term = new OperationExpression(OperationExpression.Operator.SUBTRACTION, term, this.parseExpressionTerm());
				continue;
			}
			break;
		}

		return term;
	}

	public TermExpression parseExpressionTerm() throws SyntaxException {
		Optional<NumberExpression> numberLiteral = this.parseNumberLiteral();
		Optional<VariableNode> variable = this.parseVariable();
		if (!numberLiteral.isPresent() && !variable.isPresent())
			throw Parser.unexpectedToken();
		return new TermExpression(numberLiteral.orElse(null), variable.orElse(null));
	}

	public Optional<NumberExpression> parseNumberLiteral() throws SyntaxException {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!(token instanceof NumberLiteralToken))
			return Optional.empty();
		this.skip();
		return Optional.of(new NumberExpression(token.value()));
	}

	public Optional<VariableNode> parseVariable() throws SyntaxException {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!(token instanceof IdentifierToken))
			return Optional.empty();
		this.skip();
		return Optional.of(new VariableNode(token.value()));
	}

	public Optional<StatementNode> parseRepeatStatement() throws SyntaxException {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(KeywordToken.REPEAT))
			return Optional.empty();
		this.skip();

		NumberExpression number = this.parseNumberLiteral().orElseThrow(Parser::unexpectedToken);

		token = this.peek();
		if (!token.equals(EndOfLineToken.EOL))
			throw Parser.unexpectedToken();
		this.skip();

		return Optional.of(new RepeatStatement(number, this.parseStatements()));
	}

	private Optional<StatementNode> parsePrintStatement() throws SyntaxException {
		Token token = this.peek();
		if (token.equals(EndOfFileToken.EOF))
			throw Parser.unexpectedEOF();
		if (!token.equals(KeywordToken.PRINT))
			return Optional.empty();
		this.skip();

		VariableNode variable = this.parseVariable().orElseThrow(Parser::unexpectedToken);
		return Optional.of(new PrintStatement(variable));
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
}
