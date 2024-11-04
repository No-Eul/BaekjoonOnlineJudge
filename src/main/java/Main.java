import java.util.Optional;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int t = scanner.nextInt(); t > 0; t--) {
				Expression expression = Main.parseExpression(new StringReader(scanner.next()));
				System.out.println(expression);
			}
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
				operand = new Operation(Operation.Operator.ADDITION, operand, Main.parseMultiplicativeOperation(reader));
				continue;
			}
			if (reader.peek() == '-') {
				reader.skip();
				operand = new Operation(Operation.Operator.SUBTRACTION, operand, Main.parseMultiplicativeOperation(reader));
				continue;
			}
			break;
		}
		return operand;
	}

	private static Expression parseMultiplicativeOperation(StringReader reader) {
		Expression operand = Main.parseOperand(reader);
		while (reader.canRead()) {
			if (reader.peek() == '*') {
				reader.skip();
				operand = new Operation(Operation.Operator.MULTIPLICATION, operand, Main.parseOperand(reader));
				continue;
			}
			if (reader.peek() == '/') {
				reader.skip();
				operand = new Operation(Operation.Operator.DIVISION, operand, Main.parseOperand(reader));
				continue;
			}
			break;
		}
		return operand;
	}

	private static Expression parseOperand(StringReader reader) {
		Optional<? extends Expression> optional = Main.parseVariable(reader);
		if (!optional.isPresent())
			optional = Main.parseWrappedExpression(reader);
		return optional.orElseThrow(SyntaxException::new);
	}

	private static Optional<Variable> parseVariable(StringReader reader) {
		if (!reader.canRead() || !Character.isLowerCase(reader.peek()))
			return Optional.empty();
		return Optional.of(new Variable(reader.read()));
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
		public String toString() {
			StringBuilder builder = new StringBuilder();
			boolean leftTermParenthesising = false, rightTermParenthesising = false;
			if (this.operator == Operator.MULTIPLICATION || this.operator == Operator.DIVISION) {
				if (this.left instanceof Operation) {
					Operator leftOperator = ((Operation) this.left).operator;
					if (leftOperator == Operator.ADDITION || leftOperator == Operator.SUBTRACTION)
						leftTermParenthesising = true;
				}
			}
			if (this.right instanceof Operation) {
				if (this.operator == Operator.SUBTRACTION || this.operator == Operator.MULTIPLICATION) {
					Operator rightOperator = ((Operation) this.right).operator;
					if (rightOperator == Operator.ADDITION || rightOperator == Operator.SUBTRACTION)
						rightTermParenthesising = true;
				}
				if (this.operator == Operator.DIVISION)
					rightTermParenthesising = true;
			}

			if (leftTermParenthesising)
				builder.append('(');
			builder.append(this.left.toString());
			if (leftTermParenthesising)
				builder.append(')');

			builder.append(this.operator);

			if (rightTermParenthesising)
				builder.append('(');
			builder.append(this.right.toString());
			if (rightTermParenthesising)
				builder.append(')');
			return builder.toString();
		}

		public enum Operator {
			ADDITION('+'),
			SUBTRACTION('-'),
			MULTIPLICATION('*'),
			DIVISION('/');

			private final char symbol;

			Operator(char symbol) {
				this.symbol = symbol;
			}

			@Override
			public String toString() {
				return String.valueOf(this.symbol);
			}
		}
	}

	public static class Variable implements Expression {
		private final char symbol;

		public Variable(char symbol) {
			this.symbol = symbol;
		}

		@Override
		public String toString() {
			return String.valueOf(this.symbol);
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
