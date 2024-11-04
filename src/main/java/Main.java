import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int amount = 0;
			for (int n = scanner.nextInt(); n-- > 0; amount += scanner.nextInt() % 2);
			System.out.println(amount);
		}
	}
}
