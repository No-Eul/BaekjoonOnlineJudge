import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int max = scanner.nextInt() * 3 + scanner.nextInt() * 20 + scanner.nextInt() * 120,
					mel = scanner.nextInt() * 3 + scanner.nextInt() * 20 + scanner.nextInt() * 120;
			System.out.println(max > mel ? "Max" : mel > max ? "Mel" : "Draw");
		}
	}
}
