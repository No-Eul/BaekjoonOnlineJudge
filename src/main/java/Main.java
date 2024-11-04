import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testcases = scanner.nextInt();
			for (int i = 0; i < testcases; i++) {
				int score = 0, total = 0;
				for (char c : scanner.next().toCharArray())
					total += c == 'O' ? ++score : (score = 0);
				System.out.println(total);
			}
		}
	}
}
