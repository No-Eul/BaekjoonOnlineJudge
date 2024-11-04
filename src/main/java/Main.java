import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String line;
			while (!(line = scanner.nextLine()).equals("QUIT")) {
				List<String> instructions = new ArrayList<>();
				if (!line.equals("END")) {
					do instructions.add(line);
					while (!(line = scanner.nextLine()).equals("END"));
				}

				for (int n = scanner.nextInt(); n > 0; n--) {
					Stack<Integer> stack = new Stack<>();
					stack.push(scanner.nextInt());

					try {
						for (String instruction : instructions) {
							String[] split = instruction.split(" ");
							switch (split[0]) {
								case "NUM": stack.push(Integer.parseInt(split[1])); break;
								case "POP": stack.pop(); break;
								case "INV": stack.push(-stack.pop()); break;
								case "DUP": stack.push(stack.peek()); break;
								case "SWP": {
									int value2 = stack.pop(), value1 = stack.pop();
									stack.push(value2);
									stack.push(value1);
									break;
								}
								default:
									int value2 = stack.pop(), value1 = stack.pop(), result = 0;
									switch (split[0]) {
										case "ADD": result = value1 + value2; break;
										case "SUB": result = value1 - value2; break;
										case "MUL": result = Math.multiplyExact(value1, value2); break;
										case "DIV": result = value1 / value2; break;
										case "MOD": result = value1 % value2; break;
									}
									if (Math.abs(result) > 1e9)
										throw new IllegalStateException();
									stack.push(result);
									break;
							}
						}

						if (stack.size() != 1)
							throw new IllegalStateException();
						System.out.println(stack.pop());
					} catch (EmptyStackException | ArithmeticException | IllegalStateException e) {
						System.out.println("ERROR");
					}
				}

				System.out.println();
				scanner.nextLine();
				scanner.nextLine();
			}
		}
	}
}
