import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int amount = scanner.nextInt();
			int number = scanner.nextInt();
			for (int i = 0; i < amount; i++) {
				int next = scanner.nextInt();
				if (next < number)
					System.out.printf("%d ", next);
			}
		}
	}
}
