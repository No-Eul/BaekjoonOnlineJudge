import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.printf("%d%n%d", Math.max(a + b, a - b), Math.min(a + b, a - b));
		}
	}
}
