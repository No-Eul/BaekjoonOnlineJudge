import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String line;
			while (!(line = scanner.nextLine()).equals(".")) {
				Stack<Bracket> stack = new Stack<>();
				try {
					for (char c : line.replaceAll("[^\\[\\]()]", "").toCharArray()) {
						if (c == '(') stack.push(Bracket.PAREN);
						else if (c == '[') stack.push(Bracket.BRACKET);
						else if (c == ')' && stack.pop() != Bracket.PAREN) throw new RuntimeException();
						else if (c == ']' && stack.pop() != Bracket.BRACKET) throw new RuntimeException();
					}
				} catch (RuntimeException e) {
					System.out.println("no");
					continue;
				}
				System.out.println(stack.isEmpty() ? "yes" : "no");
			}
		}
	}

	public enum Bracket {
		PAREN, BRACKET
	}
}
