import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextDouble()) {
				double x1 = scanner.nextDouble(), y1 = scanner.nextDouble(),
						x2 = scanner.nextDouble(), y2 = scanner.nextDouble(),
						x3 = scanner.nextDouble(), y3 = scanner.nextDouble(),
						mx1 = (x1 + x2) / 2, my1 = (y1 + y2) / 2,
						mx2 = (x2 + x3) / 2, my2 = (y2 + y3) / 2,
						a = x1 - mx1, b = y1 - my1,
						c = x2 - mx2, d = y2 - my2,
						p = a * mx1 + b * my1, q = c * mx2 + d * my2,
						det = a * d - b * c,
						cx = (p * d - q * b) / det, cy = (q * a - p * c) / det;
				System.out.printf("%.2f%n", Math.hypot(cx - x1, cy - y1) * Math.PI * 2);
			}
		}
	}
}
