import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = 0;
			for (long n = scanner.nextInt(), b = 0, c = 1, tmp; n-- > 0;
					tmp = a, a += c, c = b, b = tmp
			);
			System.out.println(a);
		}
	}
}
