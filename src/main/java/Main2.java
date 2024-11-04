import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testcases = scanner.nextInt();
			scanner.nextLine();
			for (int i = 0; i < testcases; i++) {
				Matcher matcher = Pattern.compile("O+").matcher(scanner.nextLine());
				int score = 0;
				while (matcher.find()) {
					int length = matcher.group().length();
					score += length * (length + 1) / 2;
				}
				System.out.println(score);
			}
		}
	}
}
