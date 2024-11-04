package dev.noeul.problemsolving.boj.p5112.parsing.statements;

import dev.noeul.problemsolving.boj.p5112.interpreter.Function;
import dev.noeul.problemsolving.boj.p5112.interpreter.Interpreter;
import dev.noeul.problemsolving.boj.p5112.parsing.Expression;
import dev.noeul.problemsolving.boj.p5112.parsing.Statement;

public class FunctionDeclarationStatement implements Statement {
	private final String name;
	private final Function.Parameter parameter;
	private final Expression expression;

	public FunctionDeclarationStatement(String name, Function.Parameter parameter, Expression expression) {
		this.name = name;
		this.parameter = parameter;
		this.expression = expression;
	}

	@Override
	public void evaluate(Interpreter interpreter) {
		interpreter.defineFunction(this.name, this.parameter, this.expression);
	}
}
