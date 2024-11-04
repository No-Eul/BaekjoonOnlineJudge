import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x1 = scanner.nextInt(), y1 = scanner.nextInt(),
					x0 = scanner.nextInt(), y0 = scanner.nextInt(),
					x2 = scanner.nextInt(), y2 = scanner.nextInt();
			System.out.print((int) Math.signum((x2 - x0) * (y1 - y0) - (x1 - x0) * (y2 - y0)));
		}
	}
}
