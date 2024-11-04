import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Deque<Integer> queue = new LinkedList<>();
			int instructions = scanner.nextInt();
			for (int i = 0; i < instructions; i++) {
				switch (scanner.next()) {
				case "push":
					queue.add(scanner.nextInt());
					break;
				case "pop":
					System.out.println(queue.isEmpty() ? -1 : queue.poll());
					break;
				case "size":
					System.out.println(queue.size());
					break;
				case "empty":
					System.out.println(queue.isEmpty() ? 1 : 0);
					break;
				case "front":
					System.out.println(queue.isEmpty() ? -1 : queue.peekFirst());
					break;
				case "back":
					System.out.println(queue.isEmpty() ? -1 : queue.peekLast());
					break;
				}
			}
		}
	}
}
