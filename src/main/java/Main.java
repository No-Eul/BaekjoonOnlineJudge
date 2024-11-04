import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int i = scanner.nextInt(); i > 0; i--) {
				int repeats = scanner.nextInt();
				String string = scanner.next();
				while (repeats-- > 0)
					System.out.print(string);
				System.out.println();
			}
		}
	}
}
