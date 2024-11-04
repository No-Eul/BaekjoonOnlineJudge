package dev.noeul.problemsolving.boj.p3203.lexer;

public enum EndOfLineToken implements Token {
	EOL;

	@Override
	public String value() {
		return "\n";
	}
}
