import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt(), x = 1;
			for (int i = n - k; i < n; x *= ++i);
			for (int i = k; i > 1; x /= i--);
			System.out.println(x);
		}
	}
}
