import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in).useDelimiter("(?=[-+])|(?<=[-+])|\\s+")) {
			int sum = scanner.nextInt();
			boolean isNegative = false;
			while (scanner.hasNext()) {
				if (scanner.next().equals("-")) isNegative = true;
				sum += isNegative ? -scanner.nextInt() : scanner.nextInt();
			}
			System.out.println(sum);
		}
	}
}
