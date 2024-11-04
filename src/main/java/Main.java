import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNext()) {
				System.out.printf("%d ", scanner.nextInt() * 6
						+ scanner.nextInt() * 3
						+ scanner.nextInt() * 2
						+ scanner.nextInt()
						+ scanner.nextInt() * 2
				);
			}
		}
	}
}
