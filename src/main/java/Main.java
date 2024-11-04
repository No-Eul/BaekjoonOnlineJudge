import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int z = scanner.nextInt(); z > 0; z--)
				System.out.println(scanner.nextInt() * scanner.nextInt() / 2);
		}
	}
}
