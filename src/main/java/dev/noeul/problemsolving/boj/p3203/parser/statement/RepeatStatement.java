package dev.noeul.problemsolving.boj.p3203.parser.statement;

import dev.noeul.problemsolving.boj.p3203.parser.StatementNode;
import dev.noeul.problemsolving.boj.p3203.parser.expression.NumberExpression;

import java.util.List;

public class RepeatStatement implements StatementNode {
	public final NumberExpression number;
	public final List<StatementNode> statements;

	public RepeatStatement(NumberExpression number, List<StatementNode> statements) {
		this.number = number;
		this.statements = statements;
	}
}
