import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int n = scanner.nextInt(); n > 0; n--) {
				for (int i = 0; i < n; i++)
					System.out.print('*');
				System.out.println();
			}
		}
	}
}
