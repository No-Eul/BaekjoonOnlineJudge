package dev.noeul.problemsolving.boj.p11516;

import dev.noeul.problemsolving.boj.p11516.lexer.Token;
import dev.noeul.problemsolving.boj.p11516.lexer.Tokenizer;
import dev.noeul.problemsolving.boj.p11516.machine.Instruction;
import dev.noeul.problemsolving.boj.p11516.machine.VirtualMachine;
import dev.noeul.problemsolving.boj.p11516.machine.VirtualMachineException;
import dev.noeul.problemsolving.boj.p11516.parser.Parser;
import dev.noeul.problemsolving.boj.p11516.parser.SyntaxTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws SyntaxException, VirtualMachineException {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int line = scanner.nextInt(); line > 0; line = scanner.nextInt()) {
				StringBuilder builder = new StringBuilder();
				scanner.nextLine();
				for (int i = 0; i < line; i++)
					builder.append(scanner.nextLine()).append('\n');
				List<Token> tokens = new Tokenizer(builder.toString()).tokenize();
				SyntaxTree parse = new Parser(tokens).parse();
				List<Instruction> instructions = new ArrayList<>();
				parse.generate(instructions);
				new VirtualMachine(instructions, System.out).execute();
			}
		}
	}
}
