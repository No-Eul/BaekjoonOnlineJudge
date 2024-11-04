package dev.noeul.problemsolving.boj.p11516.parser;

import dev.noeul.problemsolving.boj.p11516.machine.Instruction;

import java.util.List;

public interface SyntaxTree {
	void generate(List<Instruction> instructions);
}
