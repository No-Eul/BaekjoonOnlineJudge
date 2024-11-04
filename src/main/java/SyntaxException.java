public class SyntaxException extends Exception {
	public static final SyntaxException INVALID_TOKEN = new SyntaxException("Invalid or unexpected token");
	public static final SyntaxException UNEXPECTED_EOF = new SyntaxException("Unexpected end of file");
	public static final SyntaxException UNEXPECTED_TOKEN = new SyntaxException("Unexpected token");

	public SyntaxException(String message) {
		super(message);
	}
}
