import java.math.BigInteger;
import java.util.Stack;

public class Calculator {
	private final Iterable<Code> codes;
	private final Stack<BigInteger> stack = new Stack<>();

	public Calculator(Iterable<Code> codes) {
		this.codes = codes;
	}

	public BigInteger pop() {
		return this.stack.pop();
	}

	private void calculate(Code code) {
		code.instruction.execute(this.stack, code.arguments);
	}

	public BigInteger calculate() {
		for (Code code : this.codes)
			this.calculate(code);
		return this.pop();
	}
}
