package dev.noeul.problemsolving.boj.p11516.lexer;

public enum EndOfLineToken implements Token {
	EOL;

	@Override
	public String value() {
		return "\n";
	}
}
