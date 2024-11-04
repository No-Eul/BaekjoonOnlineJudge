import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a, b;
			while ((a = scanner.nextInt()) > 0 && (b = scanner.nextInt()) > 0) {
				System.out.println(b % a == 0 ? "factor" : a % b == 0 ? "multiple" : "neither");
			}
		}
	}
}
