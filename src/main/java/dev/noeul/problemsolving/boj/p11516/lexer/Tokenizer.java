package dev.noeul.problemsolving.boj.p11516.lexer;

import dev.noeul.problemsolving.boj.p11516.SyntaxException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Tokenizer {
	private final String string;
	private int pos;

	public Tokenizer(String string) {
		this.string = string;
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
			tokens.add(token.orElseThrow(Tokenizer::invalidToken));
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

	public boolean canRead(int length) {
		return this.pos + length <= this.string.length();
	}

	public char peek() {
		return this.string.charAt(this.pos);
	}

	public Optional<String> peekString(int length) {
		if (!this.canRead(length))
			return Optional.empty();
		return Optional.of(this.string.substring(this.pos, this.pos + length));
	}

	public void skip() {
		this.pos++;
	}

	public void skip(int length) {
		this.pos += length;
	}

	public Optional<String> readStringWhile(Predicate<Character> predicate) {
		int start = this.pos;
		while (this.canRead() && predicate.test(this.peek()))
			this.skip();
		if (this.pos == start)
			return Optional.empty();
		return Optional.of(this.string.substring(start, this.pos));
	}

	public void skipWhitespaces() {
		this.readStringWhile(c -> Character.isSpaceChar(c) || c == '\t');
	}

	public static SyntaxException invalidToken() {
		return new SyntaxException("Invalid or unexpected token");
	}
}
