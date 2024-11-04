import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int lines;
			while ((lines = scanner.nextInt()) > 0) {
				StringBuilder builder = new StringBuilder();
				while (lines-- > 0) {
					builder.append(scanner.next());
					if (lines > 0)
						builder.append('\n');
				}
				System.out.println(Main.parseExpression(new StringReader(builder.toString())).evaluate());
			}
		}
	}

	public static Expression parseExpression(StringReader reader) {
		return Main.parseExpression(reader, 0);
	}

	private static Expression parseExpression(StringReader reader, int depth) {
		if (!reader.canRead())
			throw new RuntimeException();
		if (reader.peek() == '\n' || reader.peek() == '\r')
			reader.skip();
		Main.skipIndentation(reader, depth);
		Optional<? extends Expression> optional = Main.parseNumber(reader);
		if (!optional.isPresent())
			optional = Main.parseOperation(reader, depth);
		return optional.orElseThrow(RuntimeException::new);
	}

	private static Optional<Number> parseNumber(StringReader reader) {
		return reader.readWhile(Character::isDigit)
				.map(Integer::parseInt)
				.map(Number::new);
	}

	private static Optional<Operation> parseOperation(StringReader reader, int depth) {
		if (!reader.canRead())
			throw new RuntimeException();
		Operation.Operator operator = null;
		for (Operation.Operator value : Operation.Operator.values()) {
			if (reader.peek() == value.symbol) {
				reader.skip();
				operator = value;
			}
		}
		if (operator == null)
			return Optional.empty();

		Expression operand = Main.parseExpression(reader, ++depth);
		do operand = new Operation(operator, operand, Main.parseExpression(reader, depth));
		while (reader.canRead() && Main.hasNextOperand(reader, depth));
		return Optional.of((Operation) operand);
	}

	private static boolean hasNextOperand(StringReader reader, int depth) {
		if (!reader.canRead())
			return false;
		int start = reader.getPosition();
		try {
			if (reader.peek() != '\n' && reader.peek() != '\r')
				throw new RuntimeException();
			reader.skip();
			for (int i = 0; i < depth; i++) {
				if (!reader.canRead() || reader.read() != '.')
					return false;
			}
			return true;
		} finally {
			reader.setPosition(start);
		}
	}

	private static void skipIndentation(StringReader reader, int depth) {
		while (depth-- > 0) {
			if (!reader.canRead() || reader.read() != '.')
				throw new RuntimeException();
		}
	}

	public interface Expression {
		int evaluate();
	}

	public static class Number implements Expression {
		private final int value;

		public Number(int value) {
			this.value = value;
		}

		@Override
		public int evaluate() {
			return this.value;
		}
	}

	public static class Operation implements Expression {
		private final Operator operator;
		private final Expression left, right;

		public Operation(Operator operator, Expression left, Expression right) {
			this.operator = operator;
			this.left = left;
			this.right = right;
		}

		@Override
		public int evaluate() {
			return this.operator.apply(this.left, this.right);
		}

		public enum Operator implements BiFunction<Expression, Expression, Integer> {
			ADDITION('+') {
				@Override
				public Integer apply(Expression left, Expression right) {
					return left.evaluate() + right.evaluate();
				}
			},
			MULTIPLICATION('*') {
				@Override
				public Integer apply(Expression left, Expression right) {
					return left.evaluate() * right.evaluate();
				}
			};

			public final char symbol;

			Operator(char symbol) {
				this.symbol = symbol;
			}
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

		public Optional<String> readWhile(Predicate<Character> predicate) {
			int start = this.pos;
			while (this.canRead() && predicate.test(this.peek()))
				this.skip();
			return start == this.pos ? Optional.empty()
					: Optional.of(this.string.substring(start, this.pos));
		}
	}
}
