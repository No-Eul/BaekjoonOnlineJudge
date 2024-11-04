package dev.noeul.problemsolving.boj.p11516.lexer;

public enum PunctuationToken implements Token {
	BARBAR("||"),
	AMPAMP("&&"),
	EQEQ("=="),
	BANGEQ("!="),
	LT("<"),
	LTEQ("<="),
	GT(">"),
	GTEQ(">="),
	PLUS("+"),
	MINUS("-"),
	ASTERISK("*"),
	SLASH("/"),
	PERCENT("%"),
	BANG("!"),
	LPAREN("("),
	RPAREN(")"),
	EQ("=");

	private final String value;

	PunctuationToken(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}
}
