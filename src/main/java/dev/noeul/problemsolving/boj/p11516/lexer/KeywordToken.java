package dev.noeul.problemsolving.boj.p11516.lexer;

public enum KeywordToken implements Token {
	IF("if"),
	ELSE("else"),
	END("end"),
	WHILE("while"),
	SET("set"),
	PRINT("print");

	private final String value;

	KeywordToken(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}
}
