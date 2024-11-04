package dev.noeul.problemsolving.boj.p3203;

import dev.noeul.problemsolving.boj.p3203.machine.Instruction;
import dev.noeul.problemsolving.boj.p3203.machine.Opcode;
import dev.noeul.problemsolving.boj.p3203.parser.ExpressionNode;
import dev.noeul.problemsolving.boj.p3203.parser.StatementNode;
import dev.noeul.problemsolving.boj.p3203.parser.SyntaxTree;
import dev.noeul.problemsolving.boj.p3203.parser.expression.NumberExpression;
import dev.noeul.problemsolving.boj.p3203.parser.expression.OperationExpression;
import dev.noeul.problemsolving.boj.p3203.parser.expression.TermExpression;
import dev.noeul.problemsolving.boj.p3203.parser.statement.AssignmentStatement;
import dev.noeul.problemsolving.boj.p3203.parser.statement.PrintStatement;
import dev.noeul.problemsolving.boj.p3203.parser.statement.ProgramStatement;
import dev.noeul.problemsolving.boj.p3203.parser.statement.RepeatStatement;

import java.util.ArrayList;
import java.util.List;

public class Generator {
	private final SyntaxTree tree;

	public Generator(SyntaxTree tree) {
		this.tree = tree;
	}

	public List<Instruction> generate() {
		List<Instruction> instructions = new ArrayList<>();
		this.generate(this.tree, instructions);
		return instructions;
	}

	public void generate(SyntaxTree tree, List<Instruction> instructions) {
		if (tree instanceof NumberExpression) {
			instructions.add(new Instruction(Opcode.PUSH, Integer.parseInt(((NumberExpression) tree).value)));
		} else if (tree instanceof TermExpression) {
			TermExpression term = (TermExpression) tree;
			if (term.numberLiteral != null)
				this.generate(term.numberLiteral, instructions);
			if (term.variable != null)
				instructions.add(new Instruction(Opcode.GETVAR, term.variable.name));
			if (term.numberLiteral != null && term.variable != null)
				instructions.add(new Instruction(Opcode.MULTIPLY));
		} else if (tree instanceof OperationExpression) {
			OperationExpression operation = (OperationExpression) tree;
			for (ExpressionNode operand : operation.operands)
				this.generate(operand, instructions);
			switch (operation.operator) {
			case ADDITION:
				instructions.add(new Instruction(Opcode.ADD));
				break;
			case SUBTRACTION:
				instructions.add(new Instruction(Opcode.SUBTRACT));
				break;
			}
		} else if (tree instanceof AssignmentStatement) {
			AssignmentStatement assignment = (AssignmentStatement) tree;
			this.generate(assignment.expression, instructions);
			instructions.add(new Instruction(Opcode.PUTVAR, assignment.variable.name));
		} else if (tree instanceof RepeatStatement) {
			RepeatStatement repeat = (RepeatStatement) tree;
			instructions.add(new Instruction(Opcode.PUSH, 0));
			int loopBeginPoint = instructions.size();
			instructions.add(new Instruction(Opcode.DUP));
			instructions.add(new Instruction(Opcode.PUSH, Integer.parseInt(repeat.number.value)));
			int breakPoint = instructions.size();
			instructions.add(null);
			for (StatementNode statement : repeat.statements)
				this.generate(statement, instructions);
			instructions.add(new Instruction(Opcode.PUSH, 1));
			instructions.add(new Instruction(Opcode.ADD));
			instructions.add(new Instruction(Opcode.JUMP, loopBeginPoint));
			instructions.set(breakPoint, new Instruction(Opcode.IFGE, instructions.size()));
			instructions.add(new Instruction(Opcode.POP));
		} else if (tree instanceof PrintStatement) {
			instructions.add(new Instruction(Opcode.PRINT, ((PrintStatement) tree).variable.name));
		} else if (tree instanceof ProgramStatement) {
			for (StatementNode statement : ((ProgramStatement) tree).statements)
				this.generate(statement, instructions);
		}
	}
}
