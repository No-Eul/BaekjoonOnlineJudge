import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int amount = scanner.nextInt();
			for (int i = 0; i < amount; i++) {
				for (int j = 0; j <= i; j++)
					System.out.print('*');
				System.out.println();
			}
		}
	}
}
