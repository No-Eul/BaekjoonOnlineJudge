import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				double x = scanner.nextDouble(), y = scanner.nextDouble();
				System.out.println(y > 0 ? x > 0 ? "Q1" : x < 0 ? "Q2" : "AXIS"
						: y < 0 ? x > 0 ? "Q4" : x < 0 ? "Q3" : "AXIS"
						: "AXIS"
				);
				if (x == 0 && y == 0) break;
			}
		}
	}
}
