import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			System.out.print(s.equals("NLCS") ? "North London Collegiate School"
					: s.equals("BHA") ? "Branksome Hall Asia"
					: s.equals("KIS") ? "Korea International School"
					: s.equals("SJA") ? "St. Johnsbury Academy" : 0
			);
		}
	}
}
