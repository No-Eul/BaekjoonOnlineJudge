package dev.noeul.problemsolving.boj.p11516.parser.expression;

import dev.noeul.problemsolving.boj.p11516.machine.Instruction;
import dev.noeul.problemsolving.boj.p11516.machine.Opcode;
import dev.noeul.problemsolving.boj.p11516.parser.ExpressionNode;

import java.util.List;

public class NumericExpression implements ExpressionNode {
	private final int value;

	public NumericExpression(int value) {
		this.value = value;
	}

	@Override
	public void generate(List<Instruction> instructions) {
		instructions.add(new Instruction(Opcode.PUSH, this.value));
	}
}
