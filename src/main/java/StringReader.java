public class StringReader {
	protected final String string;
	protected int cursor;

	public StringReader(String string) {
		this.string = string;
	}

	public String getString() {
		return this.string;
	}

	public int getCursor() {
		return this.cursor;
	}

	public boolean canRead() {
		return this.cursor < this.string.length();
	}

	public char peek() {
		return this.string.charAt(this.cursor);
	}

	public char read() {
		return this.string.charAt(this.cursor++);
	}

	public void skip() {
		this.cursor++;
	}
}
