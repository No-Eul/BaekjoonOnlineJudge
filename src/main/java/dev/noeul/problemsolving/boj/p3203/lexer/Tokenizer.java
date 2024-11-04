package dev.noeul.problemsolving.boj.p3203.lexer;

import dev.noeul.problemsolving.boj.p3203.SyntaxException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Tokenizer {
	private final String string;
	private int pos;

	public Tokenizer(String input) {
		this.string = input;
	}

	public List<Token> tokenize() throws SyntaxException {
		List<Token> tokens = new ArrayList<>();
		do {
			this.skipWhitespaces();
			Optional<Token> token = Optional.empty();
			for (TokenKind kind : TokenKind.values()) {
				if (token.isPresent()) break;
				token = kind.getToken(this);
			}
			tokens.add(token.orElseThrow(Tokenizer::throwInvalidToken));
		} while (!tokens.get(tokens.size() - 1).equals(EndOfFileToken.EOF));
		return tokens;
	}

	public int getPosition() {
		return this.pos;
	}

	public void setPosition(int pos) {
		this.pos = pos;
	}

	public boolean canRead() {
		return this.pos < this.string.length();
	}

	public char peek() {
		return this.string.charAt(this.pos);
	}

	public void skip() {
		this.pos++;
	}

	public void skipWhitespaces() {
		while (this.canRead() && Character.isSpaceChar(this.peek()))
			this.skip();
	}

	public String readString(Predicate<Character> predicate) {
		int start = this.pos;
		while (this.canRead() && predicate.test(this.peek()))
			this.skip();
		return this.string.substring(start, this.pos);
	}

	public String readStringUntil(char c) {
		int start = this.pos;
		while (this.canRead() && this.peek() != c)
			this.skip();
		return this.string.substring(start, this.pos);
	}

	public static boolean isUpperCase(char c) {
		return c >= 'A' && c <= 'Z';
	}

	public static boolean isLowerCase(char c) {
		return c >= 'a' && c <= 'z';
	}

	public static boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}

	public static SyntaxException throwInvalidToken() {
		return new SyntaxException("Invalid or unexpected token");
	}
}
