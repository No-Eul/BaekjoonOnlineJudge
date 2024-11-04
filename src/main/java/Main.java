import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			scanner.next(); scanner.next();
			System.out.println(scanner.nextBigInteger().multiply(scanner.nextBigInteger()));
		}
	}
}
