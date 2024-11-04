import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int min = 1001;
			while (n-- > 0) {
				int a = scanner.nextInt(), b = scanner.nextInt();
				if (a <= b && b < min)
					min = b;
			}
			System.out.println(min <= 1e3 ? min : -1);
		}
	}
}
