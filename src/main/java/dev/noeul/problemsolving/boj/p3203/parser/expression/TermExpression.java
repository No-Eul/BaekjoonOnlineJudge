package dev.noeul.problemsolving.boj.p3203.parser.expression;

import dev.noeul.problemsolving.boj.p3203.parser.ExpressionNode;
import dev.noeul.problemsolving.boj.p3203.parser.VariableNode;

public class TermExpression implements ExpressionNode {
	public final NumberExpression numberLiteral;
	public final VariableNode variable;

	public TermExpression(NumberExpression number, VariableNode variable) {
		this.numberLiteral = number;
		this.variable = variable;
	}
}
