import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int i = 0, n = scanner.nextInt(); i < n; i++) {
				for (int j = n - 1; j > i; j--)
					System.out.print(' ');
				System.out.print('*');
				for (int j = 0; j < i * 2 - 1; j++)
					System.out.print(' ');
				System.out.println(i > 0 ? '*' : "");
			}
		}
	}
}
