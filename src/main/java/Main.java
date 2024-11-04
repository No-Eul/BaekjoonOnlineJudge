import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String name;
			while (!(name = scanner.next()).equals("#")) {
				int age = scanner.nextInt(), weight = scanner.nextInt();
				System.out.printf("%s %s%n", name, age > 17 || weight >= 80 ? "Senior" : "Junior");
			}
		}
	}
}
