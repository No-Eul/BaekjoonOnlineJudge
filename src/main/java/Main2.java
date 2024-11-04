import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Matcher matcher = Pattern.compile("\\w+")
					.matcher(scanner.nextLine());
			int count = 0;
			while (matcher.find()) count++;
			System.out.println(count);
		}
	}
}
