import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = "WelcomeToSMUPC";
			System.out.print(s.charAt((scanner.nextInt() - 1) % s.length()));
		}
	}
}
