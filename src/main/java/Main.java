import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Set<Integer> set = new HashSet<>();
			String string = scanner.next();
			for (int number = 0; ; string = String.valueOf(number), number = 0) {
				for (int i = 0; i < string.length(); i++) {
					int digit = Character.digit(string.charAt(i), 10);
					number += digit * digit;
				}
				if (number == 1) break;
				if (set.contains(number)) {
					System.out.println("UNHAPPY");
					return;
				}
				set.add(number);
			}
			System.out.println("HAPPY");
		}
	}
}
