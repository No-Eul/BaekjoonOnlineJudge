import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Optional;

public class Main {
	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println(Main.parseExpression(reader).visit(new StringBuilder()));
		}
	}

	public static Expression parseExpression(Reader reader) throws IOException {
		return Main.parseAdditiveOperation(reader);
	}

	public static Expression parseAdditiveOperation(Reader reader) throws IOException {
		Expression operand = Main.parseMultiplicativeOperation(reader);
		while (Main.peek(reader) >= 0) {
			int peek = Main.peek(reader);
			if (peek != '+' && peek != '-') break;
			reader.skip(1);
			operand = new Operation((char) peek, operand, Main.parseMultiplicativeOperation(reader));
		}
		return operand;
	}

	public static Expression parseMultiplicativeOperation(Reader reader) throws IOException {
		Expression operand = Main.parseOperand(reader);
		while (Main.peek(reader) >= 0) {
			int peek = Main.peek(reader);
			if (peek != '*' && peek != '/') break;
			reader.skip(1);
			operand = new Operation((char) peek, operand, Main.parseOperand(reader));
		}
		return operand;
	}

	public static Expression parseOperand(Reader reader) throws IOException {
		Optional<Expression> operand = Main.parseVariable(reader);
		if (!operand.isPresent()) operand = Main.parseWrappedExpression(reader);
		return operand.orElseThrow(RuntimeException::new);
	}

	public static Optional<Expression> parseVariable(Reader reader) throws IOException {
		int peek = Main.peek(reader);
		if (peek < 0) throw new EOFException();
		if (peek < 'A' || peek > 'Z') return Optional.empty();
		reader.skip(1);
		return Optional.of(new Variable((char) peek));
	}

	public static Optional<Expression> parseWrappedExpression(Reader reader) throws IOException {
		int token = Main.peek(reader);
		if (token < 0) throw new EOFException();
		if (token != '(') return Optional.empty();
		reader.skip(1);
		Expression operation = Main.parseExpression(reader);
		token = reader.read();
		if (token < 0) throw new EOFException();
		if (token != ')') throw new RuntimeException();
		return Optional.of(operation);
	}

	public static int peek(Reader reader) throws IOException {
		reader.mark(1);
		int read = reader.read();
		reader.reset();
		return read;
	}

	public static class Operation implements Expression {
		public final char operator;
		public final Expression left, right;

		public Operation(char operator, Expression left, Expression right) {
			this.operator = operator;
			this.left = left;
			this.right = right;
		}

		@Override
		public StringBuilder visit(StringBuilder builder) {
			return this.right.visit(this.left.visit(builder))
					.append(this.operator);
		}
	}

	public static class Variable implements Expression {
		public final char name;

		public Variable(char name) {
			this.name = name;
		}

		@Override
		public StringBuilder visit(StringBuilder builder) {
			return builder.append(this.name);
		}
	}

	public interface Expression {
		StringBuilder visit(StringBuilder builder);
	}
}
