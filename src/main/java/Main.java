import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			double width = scanner.nextDouble(), height = scanner.nextDouble();
			double halfAngle = Math.atan2(height, width) / 2;
			System.out.printf("%.2f %.2f",
					width / Math.cos(halfAngle) / 2,
					height * Math.cos(halfAngle) - width * Math.sin(halfAngle)
			);
		}
	}
}
