import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			StringReader reader = new StringReader(scanner.next());
			BracketTree parsed = Main.parseBrackets(reader);
			System.out.println(reader.canRead() ? 0 : parsed.getValue());
		} catch (RuntimeException e) {
			System.out.println(0);
		}
	}

	public static BracketTree parseBrackets(StringReader reader) {
		return Main.parseCoupledBrackets(reader).orElseThrow(RuntimeException::new);
	}

	public static Optional<BracketTree> parseCoupledBrackets(StringReader reader) {
		Optional<BracketTree> optional = Main.parseBracket(reader);
		if (!optional.isPresent())
			return optional;
		while (reader.canRead()) {
			Optional<BracketTree> optional1 = Main.parseBracket(reader);
			if (!optional1.isPresent())
				break;
			optional = Optional.of(new CoupledBracket(optional.get(), optional1.get()));
		}
		return optional;
	}

	public static Optional<BracketTree> parseBracket(StringReader reader) {
		Optional<? extends BracketTree> optional = Main.parseSingleBracket(reader);
		if (!optional.isPresent())
			optional = Main.parseNestedBrackets(reader);
		return optional.map(Function.identity());
	}

	public static Optional<Bracket> parseSingleBracket(StringReader reader) {
		if (!reader.canRead())
			throw new RuntimeException();
		int start = reader.getPosition();
		if (reader.peek() == '(') {
			reader.skip();
			if (reader.peek() != ')') {
				reader.setPosition(start);
				return Optional.empty();
			}
			reader.skip();
			return Optional.of(Bracket.ROUND);
		}
		if (reader.peek() == '[') {
			reader.skip();
			if (reader.peek() != ']') {
				reader.setPosition(start);
				return Optional.empty();
			}
			reader.skip();
			return Optional.of(Bracket.SQUARE);
		}
		return Optional.empty();
	}

	public static Optional<NestedBracket> parseNestedBrackets(StringReader reader) {
		if (!reader.canRead())
			throw new RuntimeException();
		if (reader.peek() == '(') {
			reader.skip();
			BracketTree brackets = Main.parseBrackets(reader);
			if (reader.read() != ')')
				throw new RuntimeException();
			return Optional.of(new NestedBracket(Bracket.ROUND, brackets));
		}
		if (reader.peek() == '[') {
			reader.skip();
			BracketTree brackets = Main.parseBrackets(reader);
			if (reader.read() != ']')
				throw new RuntimeException();
			return Optional.of(new NestedBracket(Bracket.SQUARE, brackets));
		}
		return Optional.empty();
	}

	public interface BracketTree {
		int getValue();
	}

	public enum Bracket implements BracketTree {
		ROUND(2),
		SQUARE(3);

		private final int value;

		Bracket(int value) {
			this.value = value;
		}

		@Override
		public int getValue() {
			return this.value;
		}
	}

	public static class NestedBracket implements BracketTree {
		private final Bracket bracket;
		private final BracketTree tree;

		public NestedBracket(Bracket bracket, BracketTree tree) {
			this.bracket = bracket;
			this.tree = tree;
		}

		@Override
		public int getValue() {
			return this.tree.getValue() * this.bracket.getValue();
		}
	}

	public static class CoupledBracket implements BracketTree {
		private final BracketTree left, right;

		public CoupledBracket(BracketTree left, BracketTree right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int getValue() {
			return this.left.getValue() + this.right.getValue();
		}
	}

	public static class StringReader {
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

		public char read() {
			return this.string.charAt(this.pos++);
		}

		public void skip() {
			this.pos++;
		}
	}
}
