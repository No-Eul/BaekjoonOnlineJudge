import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), a = 1;
			for (int b = 0, tmp; n-- > 0;
					tmp = a, a = (a + b) % 10007, b = tmp * 2
			);
			System.out.println(a);
		}
	}
}
