import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int division1 = scanner.nextInt(), division2 = scanner.nextInt();
			System.out.println(Math.max(division1 + scanner.nextInt(), division2));
		}
	}
}
