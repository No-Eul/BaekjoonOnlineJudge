import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String string = scanner.next();
			System.out.println(string.startsWith("0x") ? Integer.parseInt(string.substring(2), 16)
					: string.startsWith("0") ? Integer.parseInt(string.substring(1), 8)
					: Integer.parseInt(string)
			);
		}
	}
}
