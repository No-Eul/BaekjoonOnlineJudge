package dev.noeul.problemsolving.boj.p3203.parser.expression;

import dev.noeul.problemsolving.boj.p3203.parser.ExpressionNode;

public class OperationExpression implements ExpressionNode {
	public final Operator operator;
	public final ExpressionNode[] operands;

	public OperationExpression(Operator operator, ExpressionNode... operands) {
		this.operator = operator;
		this.operands = operands;
	}

	public enum Operator {
		ADDITION,
		SUBTRACTION,
	}
}
