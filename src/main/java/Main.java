import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(scanner.next().replaceAll("[^aeiou]", "").length());
		}
	}
}
