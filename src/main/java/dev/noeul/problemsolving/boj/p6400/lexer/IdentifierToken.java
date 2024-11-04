package dev.noeul.problemsolving.boj.p6400.lexer;

import java.util.Optional;

public class IdentifierToken implements Token {
	private final char value;

	public IdentifierToken(char value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return String.valueOf(this.value);
	}

	public static Optional<Token> tokenize(StringReader reader) {
		if (!reader.canRead() || !Character.isUpperCase(reader.peek()))
			return Optional.empty();
		return Optional.of(new IdentifierToken(reader.read()));
	}
}
