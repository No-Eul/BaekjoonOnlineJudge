import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int t = scanner.nextInt(); t-- > 0;) {
				double k = scanner.nextInt() + 1, n = scanner.nextInt(), x = 1;
				for (double i = n; i < k + n; x *= i++);
				while (k > 1) x /= k--;
				System.out.println((int) x);
			}
		}
	}
}
