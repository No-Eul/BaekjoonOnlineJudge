import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int variables = scanner.nextInt();
			String expression = scanner.next();
			double[] values = new double[variables];
			for (int i = 0; i < variables; i++)
				values[i] = scanner.nextInt();
			Stack<Double> stack = new Stack<>();
			for (char c : expression.toCharArray()) {
				if (c >= 'A' && c <= 'Z')
					stack.push(values[c - 'A']);
				else {
					double value2 = stack.pop(), value1 = stack.pop();
					switch (c) {
						case '+': stack.push(value1 + value2); break;
						case '-': stack.push(value1 - value2); break;
						case '*': stack.push(value1 * value2); break;
						case '/': stack.push(value1 / value2); break;
					}
				}
			}
			System.out.printf("%.2f", stack.pop());
		}
	}
}
