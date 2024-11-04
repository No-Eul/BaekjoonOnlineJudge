package dev.noeul.problemsolving.boj.p3203.lexer;

import java.util.Optional;

public enum TokenKind {
	EOF {
		@Override
		public Optional<Token> getToken(Tokenizer tokenizer) {
			if (!tokenizer.canRead())
				return Optional.of(EndOfFileToken.EOF);
			return Optional.empty();
		}
	},
	EOL {
		@Override
		public Optional<Token> getToken(Tokenizer tokenizer) {
			if (tokenizer.canRead() && (tokenizer.peek() == '\n' || tokenizer.peek() == '\r')) {
				tokenizer.skip();
				return Optional.of(EndOfLineToken.EOL);
			}
			return Optional.empty();
		}
	},
	KEYWORD {
		@Override
		public Optional<Token> getToken(Tokenizer tokenizer) {
			int start = tokenizer.getPosition();
			String string = tokenizer.readString(Tokenizer::isUpperCase);
			if (string.isEmpty())
				return Optional.empty();
			for (KeywordToken token : KeywordToken.values()) {
				if (string.equals(token.value()))
					return Optional.of(token);
			}
			tokenizer.setPosition(start);
			return Optional.empty();
		}
	},
	PUNCTUATION {
		@Override
		public Optional<Token> getToken(Tokenizer tokenizer) {
			int start = tokenizer.getPosition();
			String string = tokenizer.readStringUntil(' ');
			if (string.isEmpty())
				return Optional.empty();
			for (PunctuationToken token : PunctuationToken.values()) {
				if (string.equals(token.value()))
					return Optional.of(token);
			}
			tokenizer.setPosition(start);
			return Optional.empty();
		}
	},
	NUMBER_LITERAL {
		@Override
		public Optional<Token> getToken(Tokenizer tokenizer) {
			String string = tokenizer.readString(Tokenizer::isDigit);
			if (string.isEmpty())
				return Optional.empty();
			return Optional.of(new NumberLiteralToken(string));
		}
	},
	IDENTIFIER {
		@Override
		public Optional<Token> getToken(Tokenizer tokenizer) {
			String string = tokenizer.readString(Tokenizer::isLowerCase);
			if (string.isEmpty())
				return Optional.empty();
			return Optional.of(new IdentifierToken(string));
		}
	};

	public abstract Optional<Token> getToken(Tokenizer tokenizer);
}
