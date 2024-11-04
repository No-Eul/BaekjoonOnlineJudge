import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String a = scanner.next(), b = scanner.next();
			int min = 50;
			for (int i = 0; i <= b.length() - a.length(); i++) {
				int difference = 0;
				for (int j = 0; j < a.length(); j++) {
					if (a.charAt(j) != b.charAt(i + j))
						difference++;
				}
				min = Math.min(min, difference);
			}
			System.out.println(min);
		}
	}
}
