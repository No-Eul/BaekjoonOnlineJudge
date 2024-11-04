import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println("V".repeat(n / 5) + "I".repeat(n % 5));
		}
	}
}
