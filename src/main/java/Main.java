import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), i = 2;
			while (n > 1) {
				if (n % i == 0) {
					System.out.println(i);
					n /= i;
				} else i++;
			}
		}
	}
}
