import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in).useDelimiter("\\W+")) {
			loop:
			for (int t = scanner.nextInt(); t > 0; t--) {
				String commands = scanner.next();
				LinkedList<String> deque = new LinkedList<>();
				for (int n = scanner.nextInt(); n > 0; n--)
					deque.add(scanner.next());

				boolean flip = false;
				for (char c : commands.toCharArray()) {
					if (c == 'R') flip ^= true;
					if (c == 'D') {
						if (deque.isEmpty()) {
							System.out.println("error");
							continue loop;
						}
						if (flip) deque.pollLast();
						else deque.pop();
					}
				}

				if (flip) Collections.reverse(deque);
				System.out.printf("[%s]%n", String.join(",", deque));
			}
		}
	}
}
