public class NumericLiteralToken extends Token {
	public final String literal;

	public NumericLiteralToken(String literal) {
		super(TokenKind.NUMERIC_LITERAL);
		this.literal = literal;
	}
}
