package dev.noeul.problemsolving.boj.p3203.lexer;

public enum KeywordToken implements Token {
	BEGIN("BEGIN"),
	REPEAT("REPEAT"),
	STOP("STOP"),
	PRINT("PRINT");

	private final String value;

	KeywordToken(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}
}
