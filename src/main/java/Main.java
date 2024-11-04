import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String number = scanner.next();
			for (int i = 9; i >= 0; i--) {
				int length = number.replaceAll("[^" + i + "]", "").length();
				while (length-- > 0)
					System.out.print(i);
			}
		}
	}
}
