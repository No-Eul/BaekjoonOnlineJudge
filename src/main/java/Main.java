import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long x = scanner.nextInt(), y = scanner.nextInt();
			System.out.println(x * x - y * y);
		}
	}
}
