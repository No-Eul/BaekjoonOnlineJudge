import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(Math.min(scanner.nextInt(), scanner.nextInt() / 2 + scanner.nextInt()));
		}
	}
}
