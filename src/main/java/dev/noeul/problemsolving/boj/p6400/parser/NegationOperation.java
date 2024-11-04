package dev.noeul.problemsolving.boj.p6400.parser;

import dev.noeul.problemsolving.boj.p6400.machine.Instruction;
import dev.noeul.problemsolving.boj.p6400.machine.Opcode;

import java.util.List;

public class NegationOperation implements Expression {
	private final Expression expression;

	public NegationOperation(Expression expression) {
		this.expression = expression;
	}

	@Override
	public void generate(List<Instruction> instructions) {
		this.expression.generate(instructions);
		instructions.add(new Instruction(Opcode.NEG));
	}
}
