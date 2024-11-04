import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.printf("%.2f", scanner.nextInt() / 4.0);
		}
	}
}
