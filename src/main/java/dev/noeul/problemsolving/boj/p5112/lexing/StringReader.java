package dev.noeul.problemsolving.boj.p5112.lexing;

import java.util.Optional;
import java.util.function.Predicate;

public class StringReader {
	private final String string;
	private int pos;

	public StringReader(String string) {
		this.string = string;
	}

	public int getPosition() {
		return this.pos;
	}

	public void setPosition(int pos) {
		this.pos = pos;
	}

	public boolean canRead() {
		return this.pos < this.string.length();
	}

	public char peek() {
		return this.string.charAt(this.pos);
	}

	public void skip() {
		this.pos++;
	}

	public Optional<String> readWhile(Predicate<Character> predicate) {
		int start = this.pos;
		while (this.canRead() && predicate.test(this.peek()))
			this.skip();
		if (this.pos == start)
			return Optional.empty();
		return Optional.of(this.string.substring(start, this.pos));
	}
}
