package dev.noeul.problemsolving.boj.p5112.lexing;

import java.util.Optional;

public enum EndOfLineToken implements Token {
	EOL;

	@Override
	public String getValue() {
		return "\\n";
	}

	public static Optional<Token> tokenize(StringReader reader) {
		if (!reader.canRead() || reader.peek() != '\n' && reader.peek() != '\r')
			return Optional.empty();
		reader.skip();
		return Optional.of(EndOfLineToken.EOL);
	}
}
