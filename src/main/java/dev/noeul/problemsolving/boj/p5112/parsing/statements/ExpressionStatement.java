package dev.noeul.problemsolving.boj.p5112.parsing.statements;

import dev.noeul.problemsolving.boj.p5112.interpreter.Interpreter;
import dev.noeul.problemsolving.boj.p5112.parsing.Expression;
import dev.noeul.problemsolving.boj.p5112.parsing.Statement;

public class ExpressionStatement implements Statement {
	private final Expression expression;

	public ExpressionStatement(Expression expression) {
		this.expression = expression;
	}

	@Override
	public void evaluate(Interpreter interpreter) {
		Interpreter.println(this.expression.evaluate(interpreter));
	}
}
