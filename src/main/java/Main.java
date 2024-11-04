import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String number = String.valueOf(scanner.nextInt() * scanner.nextInt() * scanner.nextInt());
			for (int i = 0; i < 10; i++)
				System.out.println(number.length() - number.replace(String.valueOf(i), "").length());
		}
	}
}
