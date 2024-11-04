package dev.noeul.problemsolving.boj.p11516.parser.statement;

import dev.noeul.problemsolving.boj.p11516.machine.Instruction;
import dev.noeul.problemsolving.boj.p11516.machine.Opcode;
import dev.noeul.problemsolving.boj.p11516.parser.ExpressionNode;
import dev.noeul.problemsolving.boj.p11516.parser.StatementNode;

import java.util.List;

public class WhileStatement implements StatementNode {
	private final ExpressionNode condition;
	private final List<StatementNode> statements;

	public WhileStatement(ExpressionNode condition, List<StatementNode> statements) {
		this.condition = condition;
		this.statements = statements;
	}

	@Override
	public void generate(List<Instruction> instructions) {
		int beginPoint = instructions.size();
		this.condition.generate(instructions);
		int breakPoint = instructions.size();
		instructions.add(null);
		for (StatementNode statement : this.statements)
			statement.generate(instructions);
		instructions.add(new Instruction(Opcode.JUMP, beginPoint));
		instructions.set(breakPoint, new Instruction(Opcode.IFEQ, instructions.size()));
	}
}
