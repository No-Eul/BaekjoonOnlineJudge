import java.util.Optional;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String next;
			for (int i = 1; !(next = scanner.next()).equals("()"); i++) {
				System.out.printf("%d. %b%n", i, (next.replaceAll("[^(]+", "").length() % 2 == 0
						? Main.parseOr(new StringReader(next))
						: Main.parseAnd(new StringReader(next))
				).getValue());
			}
		}
	}

	public static Tree parseAnd(StringReader reader) {
		Optional<Bool> optional = Main.parseBool(reader);
		if (optional.isPresent())
			return optional.get();
		if (reader.read() != '(')
			throw new RuntimeException();
		Tree tree = Main.parseOr(reader);
		while (reader.canRead() && reader.peek() != ')')
			tree = new And(tree, Main.parseOr(reader));
		reader.skip();
		return tree;
	}

	public static Tree parseOr(StringReader reader) {
		Optional<Bool> optional = Main.parseBool(reader);
		if (optional.isPresent())
			return optional.get();
		if (reader.read() != '(')
			throw new RuntimeException();
		Tree tree = Main.parseAnd(reader);
		while (reader.canRead() && reader.peek() != ')')
			tree = new Or(tree, Main.parseAnd(reader));
		reader.skip();
		return tree;
	}

	public static Optional<Bool> parseBool(StringReader reader) {
		if (!reader.canRead())
			throw new RuntimeException();
		switch (reader.peek()) {
			case 'T':
				reader.skip();
				return Optional.of(Bool.T);
			case 'F':
				reader.skip();
				return Optional.of(Bool.F);
		}
		return Optional.empty();
	}

	public interface Tree {
		boolean getValue();
	}

	public enum Bool implements Tree {
		T(true),
		F(false);

		private final boolean value;

		Bool(boolean value) {
			this.value = value;
		}

		@Override
		public boolean getValue() {
			return this.value;
		}
	}

	public static class And implements Tree {
		private final Tree left;
		private final Tree right;

		public And(Tree left, Tree right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public boolean getValue() {
			return this.left.getValue() && this.right.getValue();
		}
	}

	public static class Or implements Tree {
		private final Tree left;
		private final Tree right;

		public Or(Tree left, Tree right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public boolean getValue() {
			return this.left.getValue() || this.right.getValue();
		}
	}

	public static class StringReader {
		private final String string;
		private int pos;

		public StringReader(String string) {
			this.string = string;
		}

		public boolean canRead() {
			return this.pos < this.string.length();
		}

		public char peek() {
			return this.string.charAt(this.pos);
		}

		public char read() {
			return this.string.charAt(this.pos++);
		}

		public void skip() {
			this.pos++;
		}
	}
}
