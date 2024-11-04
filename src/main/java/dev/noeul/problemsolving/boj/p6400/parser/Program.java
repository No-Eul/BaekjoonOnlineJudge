package dev.noeul.problemsolving.boj.p6400.parser;

import dev.noeul.problemsolving.boj.p6400.machine.Instruction;
import dev.noeul.problemsolving.boj.p6400.machine.Opcode;

import java.util.List;

public class Program implements Statement {
	private final List<Statement> statements;

	public Program(List<Statement> statements) {
		this.statements = statements;
	}

	@Override
	public void generate(List<Instruction> instructions) {
		for (Statement statement : this.statements) {
			statement.generate(instructions);
			instructions.add(new Instruction(Opcode.PRINT));
		}
	}
}
