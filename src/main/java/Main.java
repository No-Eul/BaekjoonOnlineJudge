import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int i = scanner.nextInt(); i > 0; i--)
				System.out.printf("$%.2f%n", scanner.nextDouble() * scanner.nextDouble() * scanner.nextDouble());
		}
	}
}
