package dev.noeul.problemsolving.boj.p11516.lexer;

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
			return tokenizer.readStringWhile(Character::isLowerCase)
					.map(string -> {
						for (KeywordToken token : KeywordToken.values()) {
							if (string.equals(token.value()))
								return token;
						}
						tokenizer.setPosition(start);
						return null;
					});
		}
	},
	PUNCTUATION {
		@Override
		public Optional<Token> getToken(Tokenizer tokenizer) {
			PunctuationToken result = null;
			for (PunctuationToken token : PunctuationToken.values()) {
				String value = token.value();
				Optional<String> optional = tokenizer.peekString(value.length());
				if (!optional.isPresent())
					continue;
				String string = optional.get();
				if (string.equals(value) && (result == null || string.length() > result.value().length()))
					result = token;
			}
			if (result != null)
				tokenizer.skip(result.value().length());
			return Optional.ofNullable(result);
		}
	},
	NUMBER_LITERAL {
		@Override
		public Optional<Token> getToken(Tokenizer tokenizer) {
			return tokenizer.readStringWhile(Character::isDigit)
					.map(NumberLiteralToken::new);
		}
	},
	IDENTIFIER {
		@Override
		public Optional<Token> getToken(Tokenizer tokenizer) {
			return tokenizer.readStringWhile(Character::isLowerCase)
					.map(IdentifierToken::new);
		}

	};

	public abstract Optional<Token> getToken(Tokenizer tokenizer);
}
