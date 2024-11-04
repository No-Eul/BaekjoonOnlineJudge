import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] array = { 0, 3, 9, 16, 25, 37, 51, 66, 84 };
			for (int t = scanner.nextInt(); t > 0; t--) {
				int n = scanner.nextInt(), a = n / 21, b = n / 3 + n / 7 - a;
				System.out.println(21 * (a * (5 + b) - 9 * a * (a + 1) / 2) + array[b % 9]);
			}
		}
	}
}
