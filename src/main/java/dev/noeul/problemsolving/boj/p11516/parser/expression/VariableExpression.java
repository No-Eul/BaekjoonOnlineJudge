package dev.noeul.problemsolving.boj.p11516.parser.expression;

import dev.noeul.problemsolving.boj.p11516.machine.Instruction;
import dev.noeul.problemsolving.boj.p11516.machine.Opcode;
import dev.noeul.problemsolving.boj.p11516.parser.ExpressionNode;

import java.util.List;

public class VariableExpression implements ExpressionNode {
	private final String name;

	public VariableExpression(String name) {
		this.name = name;
	}

	@Override
	public void generate(List<Instruction> instructions) {
		instructions.add(new Instruction(Opcode.GETVAR, this.name));
	}
}
