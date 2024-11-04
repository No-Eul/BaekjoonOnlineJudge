package dev.noeul.problemsolving.boj.p5112.parsing.statements;

import dev.noeul.problemsolving.boj.p5112.interpreter.Interpreter;
import dev.noeul.problemsolving.boj.p5112.parsing.Expression;
import dev.noeul.problemsolving.boj.p5112.parsing.Statement;

public class VariableDeclarationStatement implements Statement {
	private final String name;
	private final Expression expression;

	public VariableDeclarationStatement(String name, Expression expression) {
		this.name = name;
		this.expression = expression;
	}

	@Override
	public void evaluate(Interpreter interpreter) {
		interpreter.putVariable(this.name, this.expression.evaluate(interpreter));
	}
}
