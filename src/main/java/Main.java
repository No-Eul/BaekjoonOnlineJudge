import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(Map.of(
					"NLCS", "North London Collegiate School",
					"BHA", "Branksome Hall Asia",
					"KIS", "Korea International School",
					"SJA", "St. Johnsbury Academy"
			).get(scanner.next()));
		}
	}
}
