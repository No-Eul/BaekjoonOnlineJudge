import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String line;
			while (!(line = scanner.nextLine()).equals("#"))
				System.out.println(line.replaceAll("(?i)[^aeiou]", "").length());
		}
	}
}
