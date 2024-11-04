import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n;
			while ((n = scanner.nextInt()) > 0)
				System.out.println(n * (n + 1) / 2);
		}
	}
}
