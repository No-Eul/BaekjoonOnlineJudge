import java.math.BigInteger;
import java.util.Stack;
import java.util.function.BiConsumer;

public enum Instruction {
	PUSH(1, (stack, args) -> stack.push(new BigInteger(args[0]))),
	ADD(0, (stack, args) -> {
		BigInteger popped = stack.pop();
		stack.push(stack.pop().add(popped));
	}),
	SUBTRACT(0, (stack, args) -> {
		BigInteger popped = stack.pop();
		stack.push(stack.pop().subtract(popped));
	}),
	MULTIPLY(0, (stack, args) -> {
		BigInteger popped = stack.pop();
		stack.push(stack.pop().multiply(popped));
	}),
	DIVIDE(0, (stack, args) -> {
		BigInteger divisor = stack.pop();
		BigInteger dividend = stack.pop();
		if (!dividend.remainder(divisor).equals(BigInteger.ZERO))
			throw new ArithmeticException();
		stack.push(dividend.divide(divisor));
	});

	public final int paramCount;
	private final BiConsumer<Stack<BigInteger>, String[]> operation;

	Instruction(int paramCount, BiConsumer<Stack<BigInteger>, String[]> operation) {
		this.paramCount = paramCount;
		this.operation = operation;
	}

	public void execute(Stack<BigInteger> stack, String... args) {
		if (this.paramCount != args.length)
			throw new IllegalArgumentException("Wrong number of arguments");
		this.operation.accept(stack, args);
	}
}
