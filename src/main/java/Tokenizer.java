import java.util.ArrayList;
import java.util.List;

public class Tokenizer extends StringReader {
	public Tokenizer(String string) {
		super(string);
	}

	public List<Token> tokenize() throws SyntaxException {
		List<Token> tokens = new ArrayList<>();
		scanLoop:
		while (this.canRead()) {
			for (TokenKind type : TokenKind.values()) {
				if (!type.test(this.peek())) continue;
				tokens.add(type.readToken(this));
				continue scanLoop;
			}
			throw SyntaxException.INVALID_TOKEN;
		}
		return tokens;
	}
}
