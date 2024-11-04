import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String string = scanner.next();
			for (char c = 'a'; c <= 'z'; c++)
				System.out.printf("%d ", string.indexOf(c));
		}
	}
}
