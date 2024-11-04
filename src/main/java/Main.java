import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			for (int i = 0; i < n / 5; i++)
				System.out.print('V');
			for (int i = 0; i < n % 5; i++)
				System.out.print('I');
		}
	}
}
