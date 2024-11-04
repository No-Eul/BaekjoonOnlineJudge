import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in).useDelimiter("\\D+")) {
			for (int t = scanner.nextInt(); t > 0; t--)
				System.out.println(scanner.nextInt() + scanner.nextInt());
		}
	}
}
