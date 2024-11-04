import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Stack<Integer> stack = new Stack<>();
			int instructions = scanner.nextInt();
			for (int i = 0; i < instructions; i++) {
				switch (scanner.next()) {
				case "push":
					stack.push(scanner.nextInt());
					break;
				case "pop":
					System.out.println(stack.isEmpty() ? -1 : stack.pop());
					break;
				case "size":
					System.out.println(stack.size());
					break;
				case "empty":
					System.out.println(stack.isEmpty() ? 1 : 0);
					break;
				case "top":
					System.out.println(stack.isEmpty() ? -1 : stack.peek());
					break;
				}
			}
		}
	}
}
