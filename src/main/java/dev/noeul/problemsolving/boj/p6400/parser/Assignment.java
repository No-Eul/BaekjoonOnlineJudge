package dev.noeul.problemsolving.boj.p6400.parser;

import dev.noeul.problemsolving.boj.p6400.machine.Instruction;
import dev.noeul.problemsolving.boj.p6400.machine.Opcode;

import java.util.List;

public class Assignment implements Expression, Statement {
	private final char variable;
	private final Expression expression;

	public Assignment(char variable, Expression expression) {
		this.variable = variable;
		this.expression = expression;
	}

	@Override
	public void generate(List<Instruction> instructions) {
		this.expression.generate(instructions);
		instructions.add(new Instruction(Opcode.PUTVAR, this.variable));
	}
}
