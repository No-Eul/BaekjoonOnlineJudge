package dev.noeul.problemsolving.boj.p11516.parser.statement;

import dev.noeul.problemsolving.boj.p11516.machine.Instruction;
import dev.noeul.problemsolving.boj.p11516.machine.Opcode;
import dev.noeul.problemsolving.boj.p11516.parser.ExpressionNode;
import dev.noeul.problemsolving.boj.p11516.parser.StatementNode;

import java.util.List;
import java.util.Optional;

public class IfStatement implements StatementNode {
	private final ExpressionNode condition;
	private final List<StatementNode> thenStatement;
	@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
	private final Optional<List<StatementNode>> elseStatement;

	@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
	public IfStatement(ExpressionNode condition, List<StatementNode> thenStatement, Optional<List<StatementNode>> elseStatement) {
		this.condition = condition;
		this.thenStatement = thenStatement;
		this.elseStatement = elseStatement;
	}

	@Override
	public void generate(List<Instruction> instructions) {
		this.condition.generate(instructions);
		int beginPoint = instructions.size();
		instructions.add(null);
		for (StatementNode statement : this.thenStatement)
			statement.generate(instructions);
		int thenStatementBreakPoint = 0;
		if (this.elseStatement.isPresent()) {
			thenStatementBreakPoint = instructions.size();
			instructions.add(null);
		}
		instructions.set(beginPoint, new Instruction(Opcode.IFEQ, instructions.size()));
		if (this.elseStatement.isPresent()) {
			for (StatementNode statement : this.elseStatement.get())
				statement.generate(instructions);
			instructions.set(thenStatementBreakPoint, new Instruction(Opcode.JUMP, instructions.size()));
		}
	}
}
