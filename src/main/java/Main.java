import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Set<String> cheeses = new HashSet<>();
			for (int i = scanner.nextInt(); i > 0; i--) {
				String string = scanner.next();
				if (string.endsWith("Cheese"))
					cheeses.add(string);
			}
			System.out.println(cheeses.size() > 3 ? "yummy" : "sad");
		}
	}
}
