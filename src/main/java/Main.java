import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(LocalDate.of(2014, 4, 1).plusDays(scanner.nextInt()));
		}
	}
}
