package dev.noeul.problemsolving.boj.p6400.lexer;

import java.util.Optional;

public enum EndOfFileToken implements Token {
	EOF;

	@Override
	public String getValue() {
		return null;
	}

	public static Optional<Token> tokenize(StringReader reader) {
		return reader.canRead() ? Optional.empty()
				: Optional.of(EndOfFileToken.EOF);
	}
}
