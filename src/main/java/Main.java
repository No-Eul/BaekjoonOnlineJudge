import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int i = 0; i < 3; i++) {
				Duration duration = Duration.between(
						LocalTime.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()),
						LocalTime.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt())
				);
				System.out.printf("%d %d %d%n", duration.toHours(), duration.toMinutes() % 60, duration.getSeconds() % 60);
			}
		}
	}
}
