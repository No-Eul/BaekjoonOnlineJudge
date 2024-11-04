import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String line;
			while (!(line = scanner.nextLine()).equals("#")) {
				try {
					Stack<Integer> stack = new Stack<>();
					loop:
					for (char c : line.toCharArray()) {
						switch (c) {
							case '(': stack.push(0); break;
							case ')': if (stack.peek() != 0) break loop; stack.pop(); break;
							case '{': stack.push(1); break;
							case '}': if (stack.peek() != 1) break loop; stack.pop(); break;
							case '[': stack.push(2); break;
							case ']': if (stack.peek() != 2) break loop; stack.pop(); break;
						}
					}
					System.out.println(stack.isEmpty() ? "Legal" : "Illegal");
				} catch (EmptyStackException e) {
					System.out.println("Illegal");
				}
			}
		}
	}
}
