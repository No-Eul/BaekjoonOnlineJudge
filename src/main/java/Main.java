import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String string = scanner.next();
			System.out.println(string.length() * 7
					- string.replace(":", "").length()
					- string.replace("_", "").length() * 5
			);
		}
	}
}
