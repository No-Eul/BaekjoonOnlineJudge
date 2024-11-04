import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(Main.parseExpression(new StringReader(scanner.next())).evaluate());
		}
	}

	public static Expression parseExpression(StringReader reader) {
		return Main.parseAdditiveOperation(reader);
	}

	private static Expression parseAdditiveOperation(StringReader reader) {
		Expression operand = Main.parseMultiplicativeOperation(reader);
		while (reader.canRead()) {
			if (reader.peek() == '+') {
				reader.skip();
				operand = new BinaryOperation(BinaryOperation.Operator.ADDITION, operand, Main.parseMultiplicativeOperation(reader));
			} else if (reader.peek() == '-') {
				reader.skip();
				operand = new BinaryOperation(BinaryOperation.Operator.SUBTRACTION, operand, Main.parseMultiplicativeOperation(reader));
			} else break;
		}
		return operand;
	}

	private static Expression parseMultiplicativeOperation(StringReader reader) {
		Expression operand = Main.parsePowerExpression(reader);
		while (reader.canRead()) {
			if (reader.peek() == '*') {
				reader.skip();
				operand = new BinaryOperation(BinaryOperation.Operator.MULTIPLICATION, operand, Main.parsePowerExpression(reader));
			} else if (reader.peek() == '/') {
				reader.skip();
				operand = new BinaryOperation(BinaryOperation.Operator.DIVISION, operand, Main.parsePowerExpression(reader));
			} else break;
		}
		return operand;
	}

	private static Expression parsePowerExpression(StringReader reader) {
		Expression operand = Main.parseRootExpression(reader);
		while (reader.canRead()) {
			if (reader.peek() != '^')
				break;
			reader.skip();
			operand = new BinaryOperation(BinaryOperation.Operator.POWER, operand, Main.parsePowerExpression(reader));
		}
		return operand;
	}

	private static Expression parseRootExpression(StringReader reader) {
		if (!reader.canRead())
			throw new SyntaxException();
		if (reader.peek() != '#')
			return Main.parseOperand(reader);
		reader.skip();
		return new RootOperation(Main.parseRootExpression(reader));
	}

	private static Expression parseOperand(StringReader reader) {
		Optional<? extends Expression> optional = Main.parseNumber(reader);
		if (!optional.isPresent())
			optional = Main.parseWrappedExpression(reader);
		return optional.orElseThrow(SyntaxException::new);
	}

	private static Optional<Number> parseNumber(StringReader reader) {
		Optional<String> optional = reader.readWhile(Character::isDigit);
		if (!optional.isPresent())
			return Optional.empty();
		try {
			return Optional.of(new Number(Long.parseLong(optional.get())));
		} catch (NumberFormatException e) {
			return Optional.empty();
		}
	}

	private static Optional<Expression> parseWrappedExpression(StringReader reader) {
		if (!reader.canRead() || reader.peek() != '(')
			return Optional.empty();
		reader.skip();
		Expression expression = Main.parseExpression(reader);
		if (!reader.canRead() || reader.read() != ')')
			throw new SyntaxException();
		return Optional.of(expression);
	}

	public static class SyntaxException extends RuntimeException {
	}

	public interface Expression {
		long evaluate();
	}

	public static class BinaryOperation implements Expression {
		private final Operator operator;
		private final Expression left, right;

		public BinaryOperation(Operator operator, Expression left, Expression right) {
			this.operator = operator;
			this.left = left;
			this.right = right;
		}

		@Override
		public long evaluate() {
			return this.operator.evaluate(this.left, this.right);
		}

		public enum Operator {
			ADDITION((left, right) -> left.evaluate() + right.evaluate()),
			SUBTRACTION((left, right) -> left.evaluate() - right.evaluate()),
			MULTIPLICATION((left, right) -> left.evaluate() * right.evaluate()),
			DIVISION((left, right) -> left.evaluate() / right.evaluate()),
			POWER(new BiFunction<Expression, Expression, Long>() {
				@Override
				public Long apply(Expression left, Expression right) {
					return this.pow(left.evaluate(), right.evaluate());
				}

				private long pow(long base, long power) {
					if (power == 0) return 1;
					if (power == 1) return base;
					long value = this.pow(base, power / 2);
					return value * value * (power % 2 == 0 ? 1 : base);
				}
			});

			private final BiFunction<Expression, Expression, Long> function;

			Operator(BiFunction<Expression, Expression, Long> function) {
				this.function = function;
			}

			public long evaluate(Expression left, Expression right) {
				return this.function.apply(left, right);
			}
		}
	}

	public static class RootOperation implements Expression {
		private final Expression operand;

		public RootOperation(Expression operand) {
			this.operand = operand;
		}

		@Override
		public long evaluate() {
			long value = this.operand.evaluate();
			long sqrt = (long) Math.sqrt(value);
			return sqrt * sqrt > value ? sqrt - 1 : sqrt;
		}
	}

	public static class Number implements Expression {
		private final long value;

		public Number(long value) {
			this.value = value;
		}

		@Override
		public long evaluate() {
			return this.value;
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

		public Optional<String> readWhile(Predicate<Character> predicate) {
			int start = this.pos;
			while (this.canRead() && predicate.test(this.peek()))
				this.skip();
			if (this.pos == start)
				return Optional.empty();
			return Optional.of(this.string.substring(start, this.pos));
		}
	}
}
