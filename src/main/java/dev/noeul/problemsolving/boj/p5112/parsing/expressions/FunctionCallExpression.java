package dev.noeul.problemsolving.boj.p5112.parsing.expressions;

import dev.noeul.problemsolving.boj.p5112.interpreter.Interpreter;
import dev.noeul.problemsolving.boj.p5112.parsing.Expression;

public class FunctionCallExpression implements Expression {
	private final String name;
	private final Expression argument;

	public FunctionCallExpression(String name, Expression argument) {
		this.name = name;
		this.argument = argument;
	}

	@Override
	public int evaluate(Interpreter interpreter) {
		return interpreter.callFunction(this.name, this.argument.evaluate(interpreter));
	}
}
