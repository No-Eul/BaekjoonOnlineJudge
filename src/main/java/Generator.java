import java.util.LinkedList;
import java.util.List;

public class Generator {
	private final SyntaxNode node;

	public Generator(SyntaxNode node) {
		this.node = node;
	}

	public List<Code> generate() {
		List<Code> codes = new LinkedList<>();
		this.generate(this.node, codes);
		return codes;
	}

	private void generate(SyntaxNode node, List<Code> codes) {
		if (node instanceof ConstantNode)
			codes.add(new Code(Instruction.PUSH, ((ConstantNode) node).value));
		else if (node instanceof OperatorNode) {
			for (SyntaxNode operand : ((OperatorNode) node).operands)
				this.generate(operand, codes);
			switch (((OperatorNode) node).operator) {
			case ADDICTION:
				codes.add(new Code(Instruction.ADD));
				break;
			case SUBTRACTION:
				codes.add(new Code(Instruction.SUBTRACT));
				break;
			case MULTIPLICATION:
				codes.add(new Code(Instruction.MULTIPLY));
				break;
			case DIVISION:
				codes.add(new Code(Instruction.DIVIDE));
				break;
			}
		}
	}
}
