import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			double price = scanner.nextInt(), bill = Math.pow(10, scanner.nextInt());
			System.out.println((int) (Math.round(price / bill) * bill));
		}
	}
}
