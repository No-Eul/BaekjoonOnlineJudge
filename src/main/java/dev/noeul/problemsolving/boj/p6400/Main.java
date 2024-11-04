package dev.noeul.problemsolving.boj.p6400;

import dev.noeul.problemsolving.boj.p6400.lexer.StringReader;
import dev.noeul.problemsolving.boj.p6400.lexer.TokenKind;
import dev.noeul.problemsolving.boj.p6400.machine.Instruction;
import dev.noeul.problemsolving.boj.p6400.machine.VirtualMachine;
import dev.noeul.problemsolving.boj.p6400.parser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder builder = new StringBuilder();
			String line;
			while (!(line = scanner.nextLine()).equals("#"))
				builder.append(line).append('\n');
			List<Instruction> instructions = new ArrayList<>();
			new Parser(TokenKind.tokenize(new StringReader(builder.toString()))).parse().generate(instructions);
			new VirtualMachine(instructions).execute();
		}
	}
}
