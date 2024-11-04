import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testcases = scanner.nextInt();
			while (testcases-- > 0) {
				int count = 0;
				for (char c : scanner.next().toCharArray()) {
					if (count < 0) break;
					count += c == '(' ? 1 : -1;
				}
				System.out.println(count == 0 ? "YES" : "NO");
			}
		}
	}
}
