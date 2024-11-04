import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			for (int i = 1; i <= 9; i++)
				System.out.printf("%d * %d = %d%n", n, i, n * i);
		}
	}
}
