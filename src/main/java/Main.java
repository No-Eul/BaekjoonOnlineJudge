import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			System.out.println(a == b && b == c ? (a + 10) * 1000
					: (a == b || a == c ? a + 10
							: b == c ? b + 10
							: Math.max(Math.max(a, b), c)
					) * 100
 			);
		}
	}
}
