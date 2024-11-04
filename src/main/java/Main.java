import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Stack<Integer> stack = new Stack<>();
			for (int k = scanner.nextInt(); k > 0; k--) {
				int number = scanner.nextInt();
				if (number > 0) stack.push(number);
				else stack.pop();
			}
			int sum = 0;
			for (int i : stack) sum += i;
			System.out.println(sum);
		}
	}
}
