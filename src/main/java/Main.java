import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			double ax = scanner.nextInt(), ay = scanner.nextInt(), az = scanner.nextInt(),
					bx = scanner.nextInt() - ax, by = scanner.nextInt() - ay, bz = scanner.nextInt() - az,
					cx = scanner.nextInt() - ax, cy = scanner.nextInt() - ay, cz = scanner.nextInt() - az;
			double proj = Math.min(Math.max((bx * cx + by * cy + bz * cz) / (bx * bx + by * by + bz * bz), 0), 1);
			double x = bx * proj, y = by * proj, z = bz * proj;
			System.out.println(Math.sqrt((cx - x) * (cx - x) + (cy - y) * (cy - y) + (cz - z) * (cz - z)));
		}
	}
}
