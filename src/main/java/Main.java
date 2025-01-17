import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int r = 1, c = 1, max = 0;
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					int number = scanner.nextInt();
					if (number > max) {
						max = number;
						r = i;
						c = j;
					}
				}
			}
			System.out.printf("%d%n%d %d", max, r, c);
		}
	}
}
