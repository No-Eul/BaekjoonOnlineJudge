package dev.noeul.problemsolving.boj.p11516.parser.statement;

import dev.noeul.problemsolving.boj.p11516.machine.Instruction;
import dev.noeul.problemsolving.boj.p11516.machine.Opcode;
import dev.noeul.problemsolving.boj.p11516.parser.StatementNode;

import java.util.List;

public class ProgramStatement implements StatementNode {
	private final List<StatementNode> statements;

	public ProgramStatement(List<StatementNode> statements) {
		this.statements = statements;
	}

	@Override
	public void generate(List<Instruction> instructions) {
		for (StatementNode statement : this.statements)
			statement.generate(instructions);
		instructions.add(new Instruction(Opcode.END));
	}
}
