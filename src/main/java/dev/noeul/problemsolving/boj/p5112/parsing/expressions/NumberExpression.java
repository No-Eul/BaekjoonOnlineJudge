package dev.noeul.problemsolving.boj.p5112.parsing.expressions;

import dev.noeul.problemsolving.boj.p5112.interpreter.Interpreter;
import dev.noeul.problemsolving.boj.p5112.parsing.Expression;

public class NumberExpression implements Expression {
	private final int value;

	public NumberExpression(int value) {
		this.value = value;
	}

	@Override
	public int evaluate(Interpreter interpreter) {
		return this.value;
	}
}
