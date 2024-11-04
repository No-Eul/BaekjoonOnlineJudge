package dev.noeul.problemsolving.boj.p5112.parsing.statements;

import dev.noeul.problemsolving.boj.p5112.interpreter.Interpreter;
import dev.noeul.problemsolving.boj.p5112.parsing.Statement;

import java.util.List;

public class ProgramStatement implements Statement {
	private final List<Statement> statements;

	public ProgramStatement(List<Statement> statements) {
		this.statements = statements;
	}

	@Override
	public void evaluate(Interpreter interpreter) {
		for (Statement statement : this.statements) {
			statement.evaluate(interpreter);
			if (statement instanceof ProgramEndStatement)
				break;
		}
	}
}
