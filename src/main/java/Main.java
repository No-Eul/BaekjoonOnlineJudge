import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), y = scanner.nextInt();
			System.out.println(y > 0 ? x > 0 ? "1" : "2" : x < 0 ? "3" : "4");
		}
	}
}
