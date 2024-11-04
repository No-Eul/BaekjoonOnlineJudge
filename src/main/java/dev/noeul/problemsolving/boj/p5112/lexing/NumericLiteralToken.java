package dev.noeul.problemsolving.boj.p5112.lexing;

import java.util.Optional;

public class NumericLiteralToken implements Token {
	private final String value;

	public NumericLiteralToken(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public static Optional<Token> tokenize(StringReader reader) {
		return reader.readWhile(Character::isDigit)
				.map(NumericLiteralToken::new);
	}
}
