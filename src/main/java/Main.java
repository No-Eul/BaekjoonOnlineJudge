import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long fact = 1;
			for (int i = scanner.nextInt(); i > 0; fact *= i--);
			System.out.println(fact);
		}
	}
}
