package dev.noeul.problemsolving.boj.p3203.lexer;

public enum PunctuationToken implements Token {
	EQ("="),
	PLUS("+"),
	MINUS("-");

	private final String value;

	PunctuationToken(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}
}
