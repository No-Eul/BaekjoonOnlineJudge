import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(n * (n - 1) * (n - 2) * (n - 3) / 24);
		}
	}
}
