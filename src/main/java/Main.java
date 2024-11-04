import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] array = new int[n * m];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < n * m; j++)
					array[j] += scanner.nextInt();
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++)
					System.out.printf("%d ", array[i * m + j]);
				System.out.println();
			}
		}
	}
}
