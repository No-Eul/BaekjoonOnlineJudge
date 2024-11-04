import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			while (n-- > 0) {
				int quantity = scanner.nextInt();
				int price = scanner.nextInt();
				System.out.printf("%d %d%n%d%n",
						quantity, price,
						quantity * price - --quantity * 2
				);
			}
		}
	}
}
