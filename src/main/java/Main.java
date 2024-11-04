import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testcases = scanner.nextInt();
			for (int i = 0; i < testcases; i++) {
				int repeats = scanner.nextInt();
				for (char c : scanner.next().toCharArray())
					System.out.print(String.valueOf(c).repeat(repeats));
				System.out.println();
			}

		}
	}
}
