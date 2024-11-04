package dev.noeul.problemsolving.boj.p5112.lexing;

import java.util.Optional;

public class IdentifierToken implements Token {
	private final String value;

	public IdentifierToken(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return String.valueOf(this.value);
	}

	public static Optional<Token> tokenize(StringReader reader) {
		return reader.readWhile(Character::isLetter).map(IdentifierToken::new);
	}
}
