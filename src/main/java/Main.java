import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				switch (scanner.nextInt()) {
					case 1:
						double x = scanner.nextDouble(), y = scanner.nextDouble();
						System.out.printf("%f %f%n", Math.hypot(x, y), Math.atan2(-y, -x) + Math.PI);
						break;
					case 2:
						double radius = scanner.nextDouble(), azimuth = scanner.nextDouble();
						System.out.printf("%f %f%n", radius * Math.cos(azimuth), radius * Math.sin(azimuth));
						break;
				}
			}
		}
	}
}
