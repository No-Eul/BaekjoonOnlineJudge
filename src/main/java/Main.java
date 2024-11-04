import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			for (int i = 1; i <= t; i++) {
				int a = scanner.nextInt(), b = scanner.nextInt();
				System.out.printf("Case #%d: %d + %d = %d%n", i, a, b, a + b);
			}
		}
	}
}
