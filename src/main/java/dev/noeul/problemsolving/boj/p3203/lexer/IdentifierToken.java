package dev.noeul.problemsolving.boj.p3203.lexer;

public class IdentifierToken implements Token {
	private final String value;

	public IdentifierToken(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}

	@Override
	public String toString() {
		return "IdentifierToken(" + this.value + ')';
	}
}
