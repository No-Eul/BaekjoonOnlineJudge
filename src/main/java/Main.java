import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
			int index = 0, times = 101;
			for (int i = 1; i <= n; i++) {
				for (int j = 1, sum = 0; j <= m; j++) {
					if ((sum += scanner.nextInt()) >= k && j < times) {
						index = i;
						times = j;
					}
				}
			}
			System.out.printf("%d %d", index, times);
		}
	}
}
