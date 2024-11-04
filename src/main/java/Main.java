import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(scanner.nextInt() * 3 + scanner.nextInt() * 4 + scanner.nextInt() * 5);
		}
	}
}
