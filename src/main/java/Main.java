import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int r = scanner.nextInt(), c = scanner.nextInt();
			while (r-- > 0) {
				for (int i = 0; i < c; i++)
					System.out.print('*');
				System.out.println();
			}
		}
	}
}
