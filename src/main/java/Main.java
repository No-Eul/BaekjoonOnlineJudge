import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println((int) Math.signum(scanner.nextInt() - scanner.nextInt()));
		}
	}
}
