import java.util.List;

public class Parser extends Reader<Token> {
	public Parser(List<Token> tokens) {
		super(tokens);
	}

	public SyntaxNode parse() throws SyntaxException {
		if (!this.canRead()) throw SyntaxException.UNEXPECTED_TOKEN;
		SyntaxNode expression = this.parseExpression();
		if (this.canRead()) throw SyntaxException.UNEXPECTED_TOKEN;
		return expression;
	}

	private SyntaxNode parseExpression() throws SyntaxException {
		if (!this.canRead()) throw SyntaxException.UNEXPECTED_TOKEN;
		SyntaxNode operand = this.parseTerm();

		loop:
		while (this.canRead()) {
			switch (this.peek().kind) {
			case PLUS:
				this.skip();
				operand = new OperatorNode(Operator.ADDICTION, operand, this.parseTerm());
				break;
			case MINUS:
				this.skip();
				operand = new OperatorNode(Operator.SUBTRACTION, operand, this.parseTerm());
				break;
			default: break loop;
			}
		}

		return operand;
	}

	private SyntaxNode parseTerm() throws SyntaxException {
		if (!this.canRead()) throw SyntaxException.UNEXPECTED_TOKEN;
		SyntaxNode operand = this.parseFactor();

		loop:
		while (this.canRead()) {
			switch (this.peek().kind) {
			case ASTERISK:
				this.skip();
				operand = new OperatorNode(Operator.MULTIPLICATION, operand, this.parseFactor());
				break;
			case SLASH:
				this.skip();
				operand = new OperatorNode(Operator.DIVISION, operand, this.parseFactor());
				break;
			default: break loop;
			}
		}

		return operand;
	}

	private SyntaxNode parseFactor() throws SyntaxException {
		if (!this.canRead()) throw SyntaxException.UNEXPECTED_EOF;
		switch (this.peek().kind) {
		case NUMERIC_LITERAL:
			return this.parseConstant();
		case LEFT_PARENTHESIS:
			return this.parseWrappedExpression();
		}
		throw SyntaxException.UNEXPECTED_TOKEN;
	}

	private SyntaxNode parseConstant() throws SyntaxException {
		if (!this.canRead()) throw SyntaxException.UNEXPECTED_EOF;
		if (this.peek().kind == TokenKind.NUMERIC_LITERAL)
			return new ConstantNode(((NumericLiteralToken) this.read()).literal);
		throw SyntaxException.UNEXPECTED_TOKEN;
	}

	private SyntaxNode parseWrappedExpression() throws SyntaxException {
		if (!this.canRead()) throw SyntaxException.UNEXPECTED_EOF;
		if (this.read().kind == TokenKind.LEFT_PARENTHESIS) {
			SyntaxNode wrappedExpression = this.parseExpression();
			if (!this.canRead()) throw SyntaxException.UNEXPECTED_EOF;
			if (this.read().kind == TokenKind.RIGHT_PARENTHESIS)
				return wrappedExpression;
		}
		throw SyntaxException.UNEXPECTED_TOKEN;
	}
}
