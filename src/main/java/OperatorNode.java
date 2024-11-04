public class OperatorNode implements SyntaxNode {
	public final Operator operator;
	public final SyntaxNode[] operands;

	public OperatorNode(Operator operator, SyntaxNode... operands) {
		this.operator = operator;
		this.operands = operands;
	}
}
