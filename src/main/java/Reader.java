import java.util.List;

public class Reader<T> {
	protected final List<T> elements;
	protected int cursor;

	public Reader(List<T> elements) {
		this.elements = elements;
	}

	public boolean canRead() {
		return this.cursor < this.elements.size();
	}

	public T peek() {
		return this.elements.get(this.cursor);
	}

	public T read() {
		return this.elements.get(this.cursor++);
	}

	public void skip() {
		this.cursor++;
	}
}
