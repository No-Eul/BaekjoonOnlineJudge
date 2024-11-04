import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			for (int i = 1; i < n; i++) {
				for (int j = i; j < n; j++)
					System.out.print(' ');
				if (i > 1) System.out.print('*');
				for (int j = i * 2; j > 3; j--)
					System.out.print(' ');
				System.out.println('*');
			}
			for (int i = n * 2; i > 1; i--)
				System.out.print('*');
		}
	}
}
