package dev.noeul.problemsolving.boj.p11516.lexer;

public class NumberLiteralToken implements Token {
	private final String value;

	public NumberLiteralToken(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}

	@Override
	public String toString() {
		return "NumberLiteralToken(" + this.value + ')';
	}
}
