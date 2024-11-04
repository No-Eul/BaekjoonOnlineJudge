import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(scanner.nextInt() * 56
					+ scanner.nextInt() * 24
					+ scanner.nextInt() * 14
					+ scanner.nextInt() * 6
			);
		}
	}
}
