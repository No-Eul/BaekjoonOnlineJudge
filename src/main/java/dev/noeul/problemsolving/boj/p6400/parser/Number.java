package dev.noeul.problemsolving.boj.p6400.parser;

import dev.noeul.problemsolving.boj.p6400.machine.Instruction;
import dev.noeul.problemsolving.boj.p6400.machine.Opcode;

import java.util.List;

public class Number implements Expression {
	private final int value;

	public Number(int value) {
		this.value = value;
	}

	@Override
	public void generate(List<Instruction> instructions) {
		instructions.add(new Instruction(Opcode.PUSH, this.value));
	}
}
