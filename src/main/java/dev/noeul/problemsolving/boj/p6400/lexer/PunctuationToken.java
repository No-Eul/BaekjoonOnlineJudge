package dev.noeul.problemsolving.boj.p6400.lexer;

import java.util.Optional;

public enum PunctuationToken implements Token {
	PLUS('+'),
	MINUS('-'),
	ASTERISK('*'),
	SLASH('/'),
	EQ('='),
	LPAREN('('),
	RPAREN(')'),
	LOWLINE('_');

	private final char value;

	PunctuationToken(char value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return String.valueOf(this.value);
	}

	public static Optional<Token> tokenize(StringReader reader) {
		if (!reader.canRead())
			return Optional.empty();
		for (PunctuationToken token : PunctuationToken.values()) {
			if (reader.peek() == token.value) {
				reader.skip();
				return Optional.of(token);
			}
		}
		return Optional.empty();
	}
}
