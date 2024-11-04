package dev.noeul.problemsolving.boj.p6400.lexer;

import dev.noeul.problemsolving.boj.p6400.SyntaxException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public enum TokenKind {
	EOF(EndOfFileToken::tokenize),
	EOL(EndOfLineToken::tokenize),
	PUNCTUATION(PunctuationToken::tokenize),
	NUMERIC_LITERAL(NumericLiteralToken::tokenize),
	IDENTIFIER(IdentifierToken::tokenize);

	private final Function<StringReader, Optional<Token>> tokenizer;

	TokenKind(Function<StringReader, Optional<Token>> tokenizer) {
		this.tokenizer = tokenizer;
	}

	public static List<Token> tokenize(StringReader reader) throws SyntaxException {
		List<Token> tokens = new ArrayList<>();
		do {
			reader.readWhile(Character::isSpaceChar);
			Optional<Token> token = Optional.empty();
			for (TokenKind kind : TokenKind.values()) {
				if (token.isPresent()) break;
				token = kind.tokenizer.apply(reader);
			}
			tokens.add(token.orElseThrow(TokenKind::invalidToken));
		} while (!tokens.get(tokens.size() - 1).equals(EndOfFileToken.EOF));
		return tokens;
	}

	public static SyntaxException invalidToken() {
		return new SyntaxException("Invalid or unexpected token");
	}
}
