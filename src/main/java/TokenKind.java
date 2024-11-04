import java.util.function.Predicate;

public enum TokenKind implements Predicate<Character> {
	NUMERIC_LITERAL {
		@Override
		public boolean test(Character c) {
			return c >= '0' && c <= '9';
		}

		@Override
		public Token readToken(StringReader reader) {
			int start = reader.getCursor();
			while (reader.canRead() && this.test(reader.peek()))
				reader.skip();
			return new NumericLiteralToken(reader.getString().substring(start, reader.getCursor()));
		}
	},
	PLUS {
		@Override
		public boolean test(Character c) {
			return c == '+';
		}

		@Override
		public Token readToken(StringReader reader) throws SyntaxException {
			return this.readSingleCharToken(reader, TokenKind.PLUS);
		}
	},
	MINUS {
		@Override
		public boolean test(Character c) {
			return c == '-';
		}

		@Override
		public Token readToken(StringReader reader) throws SyntaxException {
			return this.readSingleCharToken(reader, TokenKind.MINUS);
		}
	},
	ASTERISK {
		@Override
		public boolean test(Character c) {
			return c == '*';
		}

		@Override
		public Token readToken(StringReader reader) throws SyntaxException {
			return this.readSingleCharToken(reader, TokenKind.ASTERISK);
		}
	},
	SLASH {
		@Override
		public boolean test(Character c) {
			return c == '/';
		}

		@Override
		public Token readToken(StringReader reader) throws SyntaxException {
			return this.readSingleCharToken(reader, TokenKind.SLASH);
		}
	},
	LEFT_PARENTHESIS {
		@Override
		public boolean test(Character c) {
			return c == '(';
		}

		@Override
		public Token readToken(StringReader reader) throws SyntaxException {
			return this.readSingleCharToken(reader, TokenKind.LEFT_PARENTHESIS);
		}
	},
	RIGHT_PARENTHESIS {
		@Override
		public boolean test(Character c) {
			return c == ')';
		}

		@Override
		public Token readToken(StringReader reader) throws SyntaxException {
			return this.readSingleCharToken(reader, TokenKind.RIGHT_PARENTHESIS);
		}
	};

	public abstract Token readToken(StringReader reader) throws SyntaxException;

	protected Token readSingleCharToken(StringReader reader, TokenKind kind) throws SyntaxException {
		if (reader.canRead() && this.test(reader.read()))
			return new Token(kind);
		throw SyntaxException.INVALID_TOKEN;
	}
}
