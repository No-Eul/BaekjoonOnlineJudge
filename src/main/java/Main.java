import java.time.LocalTime;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			LocalTime time = LocalTime.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt())
					.plusSeconds(scanner.nextInt());
			System.out.printf("%tk %d %d", time, time.getMinute(), time.getSecond());
		}
	}
}
