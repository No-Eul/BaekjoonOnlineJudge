import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			for (int i = 1; i <= n; i++) {
				for (int j = i; j < n; j++)
					System.out.print(' ');
				for (int j = i; j > 0; j--)
					System.out.print("* ");
				System.out.println();
			}
		}
	}
}
