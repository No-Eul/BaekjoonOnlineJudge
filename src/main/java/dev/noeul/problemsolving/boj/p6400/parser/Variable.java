package dev.noeul.problemsolving.boj.p6400.parser;

import dev.noeul.problemsolving.boj.p6400.machine.Instruction;
import dev.noeul.problemsolving.boj.p6400.machine.Opcode;

import java.util.List;

public class Variable implements Expression {
	private final char name;

	public Variable(char name) {
		this.name = name;
	}

	@Override
	public void generate(List<Instruction> instructions) {
		instructions.add(new Instruction(Opcode.GETVAR, this.name));
	}
}
