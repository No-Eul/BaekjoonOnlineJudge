import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int i = 0, peoples = scanner.nextInt() * scanner.nextInt(); i < 5; i++)
				System.out.printf("%d ", scanner.nextInt() - peoples);
		}
	}
}
