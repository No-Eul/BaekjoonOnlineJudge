package dev.noeul.problemsolving.boj.p3203.parser.expression;

import dev.noeul.problemsolving.boj.p3203.parser.ExpressionNode;

public class NumberExpression implements ExpressionNode {
	public final String value;

	public NumberExpression(String value) {
		this.value = value;
	}
}
