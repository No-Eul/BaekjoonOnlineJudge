import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.printf("%.0f %.0f", n * 0.78, n * 0.956);
		}
	}
}
