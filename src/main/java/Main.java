import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				int n = scanner.nextInt() + 1;
				System.out.println(scanner.nextInt() / n);
			}
		}
	}
}
