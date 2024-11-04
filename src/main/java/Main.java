import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int a = 0, b = 0;
			while (n-- > 0) {
				int score = scanner.nextInt() - scanner.nextInt();
				if (score > 0) a++;
				if (score < 0) b++;
			}
			System.out.printf("%d %d", a, b);
		}
	}
}
