import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			LocalDateTime dateTime = LocalDateTime.parse(
					scanner.nextLine(),
					DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm", Locale.ENGLISH)
			);
			LocalDateTime start = dateTime.truncatedTo(ChronoUnit.DAYS)
					.with(TemporalAdjusters.firstDayOfYear());
			System.out.print(start.until(dateTime, ChronoUnit.NANOS) * 100.0
					/ start.until(start.plusYears(1), ChronoUnit.NANOS)
			);
		}
	}
}
