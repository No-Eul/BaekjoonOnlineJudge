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
		return Main.parseAdditionOperation(reader);
	}

	private static Expression parseAdditionOperation(StringReader reader) {
		Expression operand = Main.parseMinMaxOperation(reader);
		while (reader.canRead()) {
			if (reader.peek() == '+') {
				reader.skip();
				operand = new Operation(Operation.Operator.ADDITION, operand, Main.parseMinMaxOperation(reader));
				continue;
			}
			if (reader.peek() == '-') {
				reader.skip();
				operand = new Operation(Operation.Operator.SUBTRACTION, operand, Main.parseMinMaxOperation(reader));
				continue;
			}
			break;
		}
		return operand;
	}

	private static Expression parseMinMaxOperation(StringReader reader) {
		Expression operand = Main.parseOperand(reader);
		while (reader.canRead()) {
			if (reader.peek() == '<') {
				reader.skip();
				if (!reader.canRead() || reader.read() != '?')
					throw new SyntaxException();
				operand = new Operation(Operation.Operator.MINIMUM, operand, Main.parseOperand(reader));
				continue;
			}
			if (reader.peek() == '>') {
				reader.skip();
				if (!reader.canRead() || reader.read() != '?')
					throw new SyntaxException();
				operand = new Operation(Operation.Operator.MAXIMUM, operand, Main.parseOperand(reader));
				continue;
			}
			break;
		}
		return operand;
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
			return Optional.of(new Number(Integer.parseInt(optional.get())));
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
		int evaluate();
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
			return this.operator.evaluate(this.left, this.right);
		}

		public enum Operator {
			ADDITION((left, right) -> left.evaluate() + right.evaluate()),
			SUBTRACTION((left, right) -> left.evaluate() - right.evaluate()),
			MINIMUM((left, right) -> Math.min(left.evaluate(), right.evaluate())),
			MAXIMUM((left, right) -> Math.max(left.evaluate(), right.evaluate()));

			private final BiFunction<Expression, Expression, Integer> function;

			Operator(BiFunction<Expression, Expression, Integer> function) {
				this.function = function;
			}

			public int evaluate(Expression left, Expression right) {
				return this.function.apply(left, right);
			}
		}
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
