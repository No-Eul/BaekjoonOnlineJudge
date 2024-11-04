package dev.noeul.problemsolving.boj.p3203.parser.statement;

import dev.noeul.problemsolving.boj.p3203.parser.StatementNode;
import dev.noeul.problemsolving.boj.p3203.parser.VariableNode;

public class PrintStatement implements StatementNode {
	public final VariableNode variable;

	public PrintStatement(VariableNode variable) {
		this.variable = variable;
	}
}
