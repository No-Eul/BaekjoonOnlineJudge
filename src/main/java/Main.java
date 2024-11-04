import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int result = 0;
			while (scanner.hasNextInt()) {
				int next = scanner.nextInt();
				result += next * next % 10;
			}
			System.out.println(result % 10);
		}
	}
}
