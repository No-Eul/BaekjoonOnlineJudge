package dev.noeul.problemsolving.boj.p3203.parser.statement;

import dev.noeul.problemsolving.boj.p3203.parser.StatementNode;
import dev.noeul.problemsolving.boj.p3203.parser.SyntaxTree;

import java.util.List;

public class ProgramStatement implements SyntaxTree {
	public final List<StatementNode> statements;

	public ProgramStatement(List<StatementNode> statements) {
		this.statements = statements;
	}
}
