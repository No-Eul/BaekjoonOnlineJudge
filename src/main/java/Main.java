import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			System.out.println(scanner.nextInt() / a * scanner.nextInt() * 3);
		}
	}
}
