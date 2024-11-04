import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int amount = scanner.nextInt();
			for (int i = 0; i < amount; i++) {
				int floor = scanner.nextInt();
				scanner.nextInt();
				int customer = scanner.nextInt();
				System.out.printf(
						"%d%02d%n",
						(customer - 1) % floor + 1,
						(customer - 1) / floor + 1
				);
			}
		}
	}
}
