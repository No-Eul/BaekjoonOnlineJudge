package dev.noeul.problemsolving.boj.p3203.parser.statement;

import dev.noeul.problemsolving.boj.p3203.parser.ExpressionNode;
import dev.noeul.problemsolving.boj.p3203.parser.StatementNode;
import dev.noeul.problemsolving.boj.p3203.parser.VariableNode;

public class AssignmentStatement implements StatementNode {
	public final VariableNode variable;
	public final ExpressionNode expression;

	public AssignmentStatement(VariableNode variable, ExpressionNode expression) {
		this.variable = variable;
		this.expression = expression;
	}
}
