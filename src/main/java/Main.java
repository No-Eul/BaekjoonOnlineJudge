import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), n = a, m = b;
			while (n != m) {
				if (n < m) m -= n;
				else n -= m;
			}
			System.out.printf("%d%n%d", n, a * b / n);
		}
	}
}
