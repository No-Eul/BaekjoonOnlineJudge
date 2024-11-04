import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			System.out.println(a + b == c || b + c == a || a + c == b ? 1
					: a * b == c || b * c == a || a * c == b ? 2
					: 3
			);
		}
	}
}
