import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			System.out.println(a + b + c != 180 ? "Error"
					: a == b && b == c ? "Equilateral"
					: a == b || b == c || a == c ? "Isosceles"
					: "Scalene"
			);
		}
	}
}
