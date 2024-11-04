import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextLine())
				System.out.println(Main.parseExpression(new StringReader(scanner.nextLine())).evaluate());
		}
	}

	public static Expression parseExpression(StringReader reader) {
		return Main.parseBinaryOperation(reader);
	}

	private static Expression parseBinaryOperation(StringReader reader) {
		Expression operand = Main.parseUnaryOperation(reader);
		while (reader.canRead()) {
			if (reader.peek() == '+') {
				reader.skip();
				operand = new BinaryOperation(BinaryOperation.Operator.ADDITION, operand, Main.parseUnaryOperation(reader));
			} else if (reader.peek() == '-') {
				reader.skip();
				operand = new BinaryOperation(BinaryOperation.Operator.SUBTRACTION, operand, Main.parseUnaryOperation(reader));
			} else break;
		}
		return operand;
	}

	private static Expression parseUnaryOperation(StringReader reader) {
		if (!reader.canRead())
			throw new SyntaxException();
		if (reader.peek() == '+') {
			reader.skip();
			return new UnaryOperation(UnaryOperation.Operator.POSITIVE, Main.parseUnaryOperation(reader));
		}
		if (reader.peek() == '-') {
			reader.skip();
			return new UnaryOperation(UnaryOperation.Operator.NEGATION, Main.parseUnaryOperation(reader));
		}
		return Main.parseOperand(reader);
	}

	private static Expression parseOperand(StringReader reader) {
		Optional<? extends Expression> optional = Main.parseNumber(reader);
		if (!optional.isPresent())
			optional = Main.parseWrappedExpression(reader);
		return optional.orElseThrow(SyntaxException::new);
	}

	private static Optional<Number> parseNumber(StringReader reader) {
		if (!reader.canRead())
			throw new SyntaxException();
		if (!Character.isDigit(reader.peek()))
			return Optional.empty();
		return Optional.of(new Number(Character.digit(reader.read(), 10)));
	}

	private static Optional<Expression> parseWrappedExpression(StringReader reader) {
		if (!reader.canRead())
			throw new SyntaxException();
		if (reader.peek() != '(')
			return Optional.empty();
		reader.skip();
		Expression expression = Main.parseExpression(reader);
		if (reader.read() != ')')
			throw new SyntaxException();
		return Optional.of(expression);
	}

	public static class SyntaxException extends RuntimeException {
	}

	public interface Expression {
		int evaluate();
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
		public int evaluate() {
			return this.operator.evaluate(this.left, this.right);
		}

		public enum Operator {
			ADDITION((left, right) -> left.evaluate() + right.evaluate()),
			SUBTRACTION((left, right) -> left.evaluate() - right.evaluate());

			private final BiFunction<Expression, Expression, Integer> function;

			Operator(BiFunction<Expression, Expression, Integer> function) {
				this.function = function;
			}

			public int evaluate(Expression left, Expression right) {
				return this.function.apply(left, right);
			}
		}
	}

	public static class UnaryOperation implements Expression {
		private final Operator operator;
		private final Expression operand;

		public UnaryOperation(Operator operator, Expression operand) {
			this.operator = operator;
			this.operand = operand;
		}

		@Override
		public int evaluate() {
			return this.operator.evaluate(this.operand);
		}

		public enum Operator {
			POSITIVE(Expression::evaluate),
			NEGATION(operand -> -operand.evaluate());

			private final Function<Expression, Integer> function;

			Operator(Function<Expression, Integer> function) {
				this.function = function;
			}

			public int evaluate(Expression operand) {
				return this.function.apply(operand);
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
	}
}
