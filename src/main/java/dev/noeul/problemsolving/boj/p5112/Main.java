package dev.noeul.problemsolving.boj.p5112;

import dev.noeul.problemsolving.boj.p5112.interpreter.Interpreter;
import dev.noeul.problemsolving.boj.p5112.lexing.StringReader;
import dev.noeul.problemsolving.boj.p5112.lexing.TokenKind;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder builder = new StringBuilder();
			while (scanner.hasNextLine()) {
				builder.append(scanner.nextLine());
				if (scanner.hasNextLine())
					builder.append('\n');
			}
			TokenKind.tokenize(new StringReader(builder.toString()))
					.parse()
					.evaluate(new Interpreter());
		}
	}
}
