package dev.noeul.problemsolving.boj.p5112.lexing;

import java.util.Optional;

public enum KeywordToken implements Token {
	DEF("def"),
	SET("set"),
	PROFILE("profile"),
	EXIT("exit");

	private final String value;

	KeywordToken(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public static Optional<Token> tokenize(StringReader reader) {
		int start = reader.getPosition();
		return reader.readWhile(Character::isLowerCase)
				.map(string -> {
					for (KeywordToken token : KeywordToken.values()) {
						if (string.equals(token.getValue()))
							return token;
					}
					reader.setPosition(start);
					return null;
				});
	}
}
