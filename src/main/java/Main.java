import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), m = scanner.nextLong();
			System.out.println(n * m * 4 - (n + m) * 3 + 2);
		}
	}
}
