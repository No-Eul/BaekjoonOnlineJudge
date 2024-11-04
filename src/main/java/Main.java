import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int next;
			while ((next = scanner.nextInt()) != 0) {
				int sum;
				do {
					sum = 0;
					do sum += next % 10;
					while ((next /= 10) > 0);
				} while ((next = sum) > 9);
				System.out.println(sum);
			}
		}
	}
}
