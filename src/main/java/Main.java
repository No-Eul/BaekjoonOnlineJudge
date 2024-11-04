import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			String count = scanner.next();
			System.out.println(Character.digit(count.charAt(count.length() - 1), 10) % 2 == 0 ? a : a ^ b);
		}
	}
}
