import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			while (n-- > 0) {
				int m = scanner.nextInt();
				System.out.println(m >= 300 ? 1 : m >= 275 ? 2 : m >= 250 ? 3 : 4);
			}
		}
	}
}
