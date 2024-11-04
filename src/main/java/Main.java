import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int amount = scanner.nextInt();
			int min = 1000000,
					max = -1000000;
			for (int i = 0; i < amount; i++) {
				int next = scanner.nextInt();
				if (next < min) min = next;
				if (next > max) max = next;
			}
			System.out.printf("%d %d", min, max);
		}
	}
}
