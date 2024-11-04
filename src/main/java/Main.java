import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a, b;
			while ((a = scanner.nextInt()) > 0 && (b = scanner.nextInt()) > 0)
				System.out.println(a > b ? "Yes" : "No");
		}
	}
}
