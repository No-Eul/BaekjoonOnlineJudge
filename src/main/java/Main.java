import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			scanner.next();
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println(a < b ? "Bus" : a > b ? "Subway" : "Anything");
		}
	}
}
