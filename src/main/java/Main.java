import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			scanner.next();
			System.out.print(scanner.next().replaceAll("[^aeiou]", "").length());
		}
	}
}
