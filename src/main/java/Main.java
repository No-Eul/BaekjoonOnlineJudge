import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testcases = scanner.nextInt();
			for (int i = 0; i < testcases; i++) {
				int repeats = scanner.nextInt();
				for (char c : scanner.next().toCharArray()) {
					for (int j = 0; j < repeats; j++)
						System.out.print(c);
				}
				System.out.println();
			}

		}
	}
}
