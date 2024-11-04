import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int lines = scanner.nextInt();
			for (int i = 1; i <= lines; i++)
				System.out.printf("Hello World, Judge %d!%n", i);
		}
	}
}
