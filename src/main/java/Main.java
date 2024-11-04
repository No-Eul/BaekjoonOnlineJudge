import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextLine())
				System.out.println(Main.parseExpression(new StringReader(scanner.nextLine())));
		}
	}

	public static Expression parseExpression(StringReader reader) {
		Expression operand = Main.parseTerm(reader);
		while (reader.canRead() && reader.peek() == '+') {
			reader.skip();
			operand = new Operation(Operation.Operator.ADDITION, operand, Main.parseTerm(reader));
		}
		return operand;
	}

	private static Expression parseTerm(StringReader reader) {
		Expression left = Main.parseFactor(reader).orElse(null);
		if (left == null)
			throw new SyntaxException();
		Optional<Expression> right;
		while (reader.canRead() && (right = Main.parseFactor(reader)).isPresent())
			left = new Operation(Operation.Operator.MULTIPLICATION, left, right.get());
		return left;
	}

	private static Optional<Expression> parseFactor(StringReader reader) {
		Optional<? extends Expression> optional = Main.parseVariable(reader);
		if (!optional.isPresent())
			optional = Main.parseWrappedExpression(reader);
		return optional.map(Function.identity());
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
			boolean leftParenthesising = this.operator == Operator.MULTIPLICATION
					&& this.left instanceof Operation
					&& ((Operation) this.left).operator == Operator.ADDITION;
			boolean rightParenthesising = this.operator == Operator.MULTIPLICATION
					&& this.right instanceof Operation
					&& ((Operation) this.right).operator == Operator.ADDITION;
			if (leftParenthesising)
				builder.append('(');
			builder.append(this.left.toString());
			if (leftParenthesising)
				builder.append(')');

			builder.append(this.operator);

			if (rightParenthesising)
				builder.append('(');
			builder.append(this.right.toString());
			if (rightParenthesising)
				builder.append(')');
			return builder.toString();
		}

		public enum Operator {
			ADDITION("+"),
			MULTIPLICATION("");

			private final String symbol;

			Operator(String symbol) {
				this.symbol = symbol;
			}

			@Override
			public String toString() {
				return this.symbol;
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
