import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int i = scanner.nextInt(); i > 0; i--) {
				System.out.printf("$%.2f%n",
						scanner.nextInt() * 350.34
						+ scanner.nextInt() * 230.9
						+ scanner.nextInt() * 190.55
						+ scanner.nextInt() * 125.3
						+ scanner.nextInt() * 180.9
				);
			}
		}
	}
}
