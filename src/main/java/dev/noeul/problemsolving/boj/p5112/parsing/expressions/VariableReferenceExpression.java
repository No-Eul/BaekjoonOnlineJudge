package dev.noeul.problemsolving.boj.p5112.parsing.expressions;

import dev.noeul.problemsolving.boj.p5112.interpreter.Interpreter;
import dev.noeul.problemsolving.boj.p5112.parsing.Expression;

public class VariableReferenceExpression implements Expression {
	private final String name;

	public VariableReferenceExpression(String name) {
		this.name = name;
	}

	@Override
	public int evaluate(Interpreter interpreter) {
		return interpreter.getVariable(this.name);
	}
}
