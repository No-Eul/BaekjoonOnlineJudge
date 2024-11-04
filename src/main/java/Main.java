import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int apples1 = scanner.nextInt(), oranges1 = scanner.nextInt(),
				apples2 = scanner.nextInt(), oranges2 = scanner.nextInt();
			System.out.println(Math.min(apples1 + oranges2, apples2 + oranges1));
		}
	}
}
