import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(switch (scanner.next()) {
				case "NLCS" -> "North London Collegiate School";
				case "BHA" -> "Branksome Hall Asia";
				case "KIS" -> "Korea International School";
				case "SJA" -> "St. Johnsbury Academy";
				default -> 0;
			});
		}
	}
}
