import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) throws ParseException {
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextLine()) {
				Value impedance = Main.parseImpedance(new StringReader(scanner.nextLine())).getValue();
				System.out.printf("%d/%d%n", impedance.numerator, impedance.denominator);
			}
		}
	}

	public static Impedance parseImpedance(StringReader reader) throws ParseException {
		return Main.parseParallelConnection(reader);
	}

	public static Impedance parseParallelConnection(StringReader reader) throws ParseException {
		Impedance impedance = Main.parseSerialConnection(reader);
		while (reader.canRead()) {
			reader.skipWhitespaces();
			if (reader.peek() == '|') {
				reader.skip();
				impedance = new Connection(true, impedance, Main.parseSerialConnection(reader));
				continue;
			}
			break;
		}
		return impedance;
	}

	public static Impedance parseSerialConnection(StringReader reader) throws ParseException {
		Impedance impedance = Main.parseNode(reader);
		while (reader.canRead()) {
			reader.skipWhitespaces();
			if (reader.peek() == '&') {
				reader.skip();
				impedance = new Connection(false, impedance, Main.parseNode(reader));
				continue;
			}
			break;
		}
		return impedance;
	}

	public static Impedance parseNode(StringReader reader) throws ParseException {
		Optional<? extends Impedance> optional = Main.parseValue(reader);
		if (!optional.isPresent())
			optional = Main.parseWrappedImpedance(reader);
		return optional.orElseThrow(ParseException::new);
	}

	public static Optional<Value> parseValue(StringReader reader) throws ParseException {
		if (!reader.canRead())
			return Optional.empty();
		reader.skipWhitespaces();
		Optional<Integer> a = reader.readInteger();
		if (!a.isPresent())
			return Optional.empty();
		if (!reader.canRead() || reader.read() != '/')
			throw new ParseException();
		Optional<Integer> b = reader.readInteger();
		if (!b.isPresent())
			throw new ParseException();
		return Optional.of(new Value(a.get(), b.get()));
	}

	public static Optional<Impedance> parseWrappedImpedance(StringReader reader) throws ParseException {
		if (!reader.canRead())
			return Optional.empty();
		reader.skipWhitespaces();
		if (reader.read() != '(') return Optional.empty();
		Impedance optional = Main.parseImpedance(reader);
		if (!reader.canRead())
			throw new ParseException();
		reader.skipWhitespaces();
		if (reader.read() != ')')
			throw new ParseException();
		return Optional.of(optional);
	}

	public interface Impedance {
		Value getValue();
	}

	public static class Value implements Impedance {
		public final int numerator, denominator;

		public Value(int numerator, int denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
		}

		@Override
		public Value getValue() {
			return this.normalize();
		}

		public Value normalize() {
			int gcd = Value.getGcd(this.numerator, this.denominator);
			return new Value(this.numerator / gcd, this.denominator / gcd);
		}

		public Value add(Value addend) {
			int lcm = Value.getLcm(this.denominator, addend.denominator);
			return new Value(lcm / this.denominator * this.numerator + lcm / addend.denominator * addend.numerator, lcm).normalize();
		}

		public Value inverse() {
			return new Value(this.denominator, this.numerator);
		}

		private static int getLcm(int a, int b) {
			for (int p = a, q = b; a != b; ) {
				if (a < b) a += p;
				else b += q;
			}
			return a;
		}

		private static int getGcd(int a, int b) {
			while (a != b) {
				if (a < b) b -= a;
				else a -= b;
			}
			return a;
		}
	}

	public static class Connection implements Impedance {
		private final boolean isParallel;
		private final Impedance a;
		private final Impedance b;

		public Connection(boolean isParallel, Impedance a, Impedance b) {
			this.isParallel = isParallel;
			this.a = a;
			this.b = b;
		}

		@Override
		public Value getValue() {
			Value a = this.a.getValue();
			Value b = this.b.getValue();
			return this.isParallel ? a.inverse().add(b.inverse()).inverse() : a.add(b);
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

		public char read() {
			return this.string.charAt(this.pos++);
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

		public Optional<Integer> readInteger() {
			try {
				return this.readWhile(Character::isDigit).map(Integer::parseInt);
			} catch (NumberFormatException e) {
				return Optional.empty();
			}
		}

		public void skipWhitespaces() {
			this.readWhile(Character::isWhitespace);
		}
	}

	public static class ParseException extends Exception {
	}
}
