import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String string = scanner.next();
			System.out.println((string.contains("7") ? 2 : 0) + (Integer.parseInt(string) % 7 == 0 ? 1 : 0));
		}
	}
}
