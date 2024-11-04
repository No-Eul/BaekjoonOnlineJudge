import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				double x = 0, y = 0, z = 0, radius, elevation, azimuth;
				int input = scanner.nextInt(), output = scanner.nextInt();
				switch (input) {
					case 1:
						x = scanner.nextDouble();
						y = scanner.nextDouble();
						z = scanner.nextDouble();
						break;
					case 2:
						radius = scanner.nextDouble();
						azimuth = scanner.nextDouble();
						x = radius * Math.cos(azimuth);
						y = radius * Math.sin(azimuth);
						z = scanner.nextDouble();
						break;
					case 3:
						radius = scanner.nextDouble();
						elevation = scanner.nextDouble();
						azimuth = scanner.nextDouble();
						x = radius * Math.sin(elevation) * Math.cos(azimuth);
						y = radius * Math.sin(elevation) * Math.sin(azimuth);
						z = radius * Math.cos(elevation);
						break;
				}
				switch (output) {
					case 1:
						System.out.printf("%f %f %f%n", x, y, z);
						break;
					case 2:
						System.out.printf("%f %f %f%n", Math.hypot(x, y), Math.atan2(-y, -x) + Math.PI, z);
						break;
					case 3:
						radius = Math.sqrt(x * x + y * y + z * z);
						System.out.printf("%f %f %f%n",
								radius,
								radius > 0 ? Math.acos(z / radius) : 0,
								Math.atan2(-y, -x) + Math.PI
						);
						break;
				}
			}
		}
	}
}
