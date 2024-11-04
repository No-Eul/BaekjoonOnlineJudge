package dev.noeul.problemsolving.boj.p5112.parsing;

import dev.noeul.problemsolving.boj.p5112.interpreter.Interpreter;

public interface Expression extends SyntaxTree {
	int evaluate(Interpreter interpreter);
}
