package dev.noeul.problemsolving.boj.p5112.parsing.statements;

import dev.noeul.problemsolving.boj.p5112.interpreter.Interpreter;
import dev.noeul.problemsolving.boj.p5112.parsing.Statement;

public class ProfilingStatement implements Statement {
	@Override
	public void evaluate(Interpreter interpreter) {
		interpreter.printProfilingResult();
	}
}
