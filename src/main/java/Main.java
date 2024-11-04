import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(Main.parse(new StringReader(scanner.nextLine())));
		}
	}

	public static UniversalStatement parse(StringReader reader) {
		List<Statement> statements = new ArrayList<>();
		Optional<EndStatement> optional;
		while (!(optional = Main.parseEndStatement(reader)).isPresent())
			statements.add(Main.parseStatement(reader));
		statements.add(optional.get());
		return new UniversalStatement(statements);
	}

	private static Statement parseStatement(StringReader reader) {
		Optional<? extends Statement> optional = Main.parseSingleStatement(reader);
		if (!optional.isPresent())
			optional = Main.parseIfStatement(reader);
		return optional.orElseThrow(RuntimeException::new);
	}

	private static Optional<EndStatement> parseEndStatement(StringReader reader) {
		reader.readWhile(Character::isWhitespace);
		if (!reader.canRead())
			throw new RuntimeException();
		int start = reader.getPosition();
		Optional<String> optional = reader.readWhile(Character::isAlphabetic).filter("end"::equals);
		if (!optional.isPresent()) {
			reader.setPosition(start);
			return Optional.empty();
		}
		return Optional.of(new EndStatement());
	}

	private static Optional<Statement> parseSingleStatement(StringReader reader) {
		reader.readWhile(Character::isWhitespace);
		if (!reader.canRead())
			throw new RuntimeException();
		if (reader.peek() != ';')
			return Optional.empty();
		reader.skip();
		return Optional.of(new SingleStatement());
	}

	private static Optional<IfStatement> parseIfStatement(StringReader reader) {
		reader.readWhile(Character::isWhitespace);
		if (!reader.canRead())
			throw new RuntimeException();
		int start = reader.getPosition();
		Optional<String> optional = reader.readWhile(Character::isAlphabetic).filter("if"::equals);
		if (!optional.isPresent()) {
			reader.setPosition(start);
			return Optional.empty();
		}
		List<Statement> statements = Main.parseBlockStatement(reader);

		reader.readWhile(Character::isWhitespace);
		if (!reader.canRead())
			throw new RuntimeException();
		start = reader.getPosition();
		optional = reader.readWhile(Character::isAlphabetic).filter("else"::equals);
		if (!optional.isPresent()) {
			reader.setPosition(start);
			return Optional.of(new IfStatement(statements));
		}
		return Optional.of(new IfStatement(statements, Main.parseBlockStatement(reader)));
	}

	private static List<Statement> parseBlockStatement(StringReader reader) {
		reader.readWhile(Character::isWhitespace);
		if (!reader.canRead())
			throw new RuntimeException();
		if (reader.peek() != '{')
			return Collections.singletonList(Main.parseStatement(reader));
		reader.skip();
		List<Statement> statements = new ArrayList<>();
		while (true) {
			reader.readWhile(Character::isWhitespace);
			if (!reader.canRead())
				throw new RuntimeException();
			if (reader.peek() == '}')
				break;
			statements.add(Main.parseStatement(reader));
		}
		reader.skip();
		return statements;
	}

	public interface Statement {
	}

	public static class UniversalStatement implements Statement {
		private final List<Statement> statements;

		public UniversalStatement(List<Statement> statements) {
			this.statements = statements;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			Iterator<Statement> iterator = this.statements.iterator();
			while (iterator.hasNext()) {
				builder.append(iterator.next());
				if (iterator.hasNext())
					builder.append(' ');
			}
			return builder.toString();
		}
	}

	public static class SingleStatement implements Statement {
		@Override
		public String toString() {
			return ";";
		}
	}

	public static class EndStatement implements Statement {
		@Override
		public String toString() {
			return "end";
		}
	}

	public static class IfStatement implements Statement {
		private final List<Statement> statements;
		private final Optional<List<Statement>> elseStatements;

		public IfStatement(List<Statement> statements) {
			this.statements = statements;
			this.elseStatements = Optional.empty();
		}

		public IfStatement(List<Statement> statements, List<Statement> elseStatements) {
			this.statements = statements;
			this.elseStatements = Optional.of(elseStatements);
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder("if { ");
			this.statements.forEach(statement -> builder.append(statement).append(' '));
			builder.append('}');
			this.elseStatements.ifPresent(statements -> {
				builder.append(" else { ");
				statements.forEach(statement -> builder.append(statement).append(' '));
				builder.append('}');
			});
			return builder.toString();
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
			return this.pos == start ? Optional.empty()
					: Optional.of(this.string.substring(start, this.pos));
		}
	}
}
