import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			double m, a, b;
			while ((m = scanner.nextInt()) > 0
					&& (a = scanner.nextInt()) > 0
					&& (b = scanner.nextInt()) > 0
			) {
				long time = Math.round(m * (b - a) / a / b * 3600);
				System.out.printf("%d:%02d:%02d%n", time / 3600, time / 60 % 60, time % 60);
			}
		}
	}
}
