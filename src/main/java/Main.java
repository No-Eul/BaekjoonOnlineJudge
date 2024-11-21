import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			System.out.println((n + 1) * (n * 3 + 2) / 2 % 45678);
		}
	}
}
