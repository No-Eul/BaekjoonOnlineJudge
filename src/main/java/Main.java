import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Deque<Integer> queue = new LinkedList<>();
			for (int n = scanner.nextInt(); n > 0; n--)
				queue.addFirst(n);
			while (queue.size() > 1) {
				queue.remove();
				if (queue.size() > 1)
					queue.add(queue.remove());
			}
			System.out.println(queue.peek());
		}
	}
}
