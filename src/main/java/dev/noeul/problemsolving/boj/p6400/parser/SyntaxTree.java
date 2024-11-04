package dev.noeul.problemsolving.boj.p6400.parser;

import dev.noeul.problemsolving.boj.p6400.machine.Instruction;

import java.util.List;

public interface SyntaxTree {
	void generate(List<Instruction> instructions);
}
