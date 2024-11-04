package dev.noeul.problemsolving.boj.p5112.parsing;

import dev.noeul.problemsolving.boj.p5112.interpreter.Interpreter;

public interface Statement extends SyntaxTree {
	void evaluate(Interpreter interpreter);
}
