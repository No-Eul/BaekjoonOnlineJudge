import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			BinaryOperation.Operator[] operators = new BinaryOperation.Operator[4];
			for (BinaryOperation.Operator value : BinaryOperation.Operator.values())
				operators[scanner.nextInt() - 1] = value;
			scanner.nextLine();
			System.out.println(Main.parseExpression(new StringReader(scanner.nextLine()), operators, 0).evaluate());
		}
	}

	public static Expression parseExpression(
			StringReader reader,
			BinaryOperation.Operator[] operators,
			int level
	) {
		if (level == operators.length)
			return Main.parseNumber(reader);
		Expression operand = Main.parseExpression(reader, operators, level + 1);
		while (reader.canRead()) {
			if (reader.peek() == operators[level].symbol) {
				reader.skip();
				operand = new BinaryOperation(operators[level], operand, Main.parseExpression(reader, operators, level));
			} else break;
		}
		return operand;
	}

	public static Number parseNumber(StringReader reader) {
		return reader.readWhile(Character::isDigit)
				.map(Long::parseLong)
				.map(Number::new)
				.orElseThrow(RuntimeException::new);
	}

	public interface Expression {
		long evaluate();
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
			return this.operator.apply(this.left, this.right);
		}

		public enum Operator implements BiFunction<Expression, Expression, Long> {
			ADDITION('+') {
				@Override
				public Long apply(Expression left, Expression right) {
					return right.evaluate() + left.evaluate();
				}
			},
			SUBTRACTION('-') {
				@Override
				public Long apply(Expression left, Expression right) {
					return right.evaluate() - left.evaluate();
				}
			},
			MULTIPLICATION('*') {
				@Override
				public Long apply(Expression left, Expression right) {
					return right.evaluate() * left.evaluate();
				}
			},
			DIVISION('/') {
				@Override
				public Long apply(Expression left, Expression right) {
					return right.evaluate() / left.evaluate();
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
			return this.pos == start ? Optional.empty()
					: Optional.of(this.string.substring(start, this.pos));
		}
	}
}
