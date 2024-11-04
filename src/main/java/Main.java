import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int n = scanner.nextInt(); n > 0; n--) {
				int coefficient = scanner.nextInt(), water = scanner.nextInt(), amount = scanner.nextInt();
				System.out.println(coefficient * (amount - 1) + water);
			}
		}
	}
}
