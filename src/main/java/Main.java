import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int t = scanner.nextInt(); t-- > 0; ) {
				int n = scanner.nextInt(), a = 0, b = 1;
				for (int tmp; n-- > 0; tmp = a, a += b, b = tmp);
				System.out.printf("%d %d%n", b, a);
			}
		}
	}
}
