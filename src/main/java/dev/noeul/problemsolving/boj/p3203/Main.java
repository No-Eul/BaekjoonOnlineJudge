package dev.noeul.problemsolving.boj.p3203;

import dev.noeul.problemsolving.boj.p3203.lexer.Token;
import dev.noeul.problemsolving.boj.p3203.lexer.Tokenizer;
import dev.noeul.problemsolving.boj.p3203.machine.Instruction;
import dev.noeul.problemsolving.boj.p3203.machine.VirtualMachine;
import dev.noeul.problemsolving.boj.p3203.machine.VirtualMachineException;
import dev.noeul.problemsolving.boj.p3203.parser.Parser;
import dev.noeul.problemsolving.boj.p3203.parser.SyntaxTree;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws SyntaxException, VirtualMachineException {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder builder = new StringBuilder();
			while (scanner.hasNextLine()) {
				builder.append(scanner.nextLine());
				if (scanner.hasNextLine())
					builder.append('\n');
			}
			List<Token> tokenize = new Tokenizer(builder.toString()).tokenize();
			SyntaxTree parse = new Parser(tokenize).parse();
			List<Instruction> generate = new Generator(parse).generate();
			new VirtualMachine(generate, System.out).execute();
		}
	}
}
