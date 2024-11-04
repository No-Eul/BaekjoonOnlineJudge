import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Deque<Integer> deque = new LinkedList<>();
			for (int n = scanner.nextInt(); n > 0; n--) {
				switch (scanner.next()) {
					case "push_front": deque.push(scanner.nextInt()); break;
					case "push_back": deque.add(scanner.nextInt()); break;
					case "pop_front": System.out.println(deque.isEmpty() ? -1 : deque.pop()); break;
					case "pop_back": System.out.println(deque.isEmpty() ? -1 : deque.pollLast()); break;
					case "size": System.out.println(deque.size()); break;
					case "empty": System.out.println(deque.isEmpty() ? 1 : 0); break;
					case "front": System.out.println(deque.isEmpty() ? -1 : deque.peek()); break;
					case "back": System.out.println(deque.isEmpty() ? -1 : deque.getLast()); break;
				}
			}
		}
	}
}
