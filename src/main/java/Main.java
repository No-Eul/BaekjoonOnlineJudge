import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			double voltage = scanner.nextDouble(),
					resistance = scanner.nextDouble(),
					capacitance = scanner.nextDouble();
			for (int n = scanner.nextInt(); n > 0; n--)
				System.out.printf("%.3f%n", voltage / Math.hypot(resistance, -1 / (scanner.nextDouble() * capacitance)));
		}
	}
}
