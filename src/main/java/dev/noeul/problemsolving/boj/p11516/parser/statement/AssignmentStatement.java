package dev.noeul.problemsolving.boj.p11516.parser.statement;

import dev.noeul.problemsolving.boj.p11516.machine.Instruction;
import dev.noeul.problemsolving.boj.p11516.machine.Opcode;
import dev.noeul.problemsolving.boj.p11516.parser.ExpressionNode;
import dev.noeul.problemsolving.boj.p11516.parser.StatementNode;

import java.util.List;

public class AssignmentStatement implements StatementNode {
	private final String variable;
	private final ExpressionNode expression;

	public AssignmentStatement(String variable, ExpressionNode expression) {
		this.variable = variable;
		this.expression = expression;
	}

	@Override
	public void generate(List<Instruction> instructions) {
		this.expression.generate(instructions);
		instructions.add(new Instruction(Opcode.PUTVAR, this.variable));
	}
}
