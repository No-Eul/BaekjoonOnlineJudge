import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int count = 0;
			Pattern pattern = Pattern.compile("(.)\\1*");
			loop:
			for (int n = scanner.nextInt(); n > 0; n--) {
				Set<Character> set = new HashSet<>();
				Matcher matcher = pattern.matcher(scanner.next());
				while (matcher.find()) {
					char c = matcher.group().charAt(0);
					if (set.contains(c))
						continue loop;
					set.add(c);
				}
				count++;
			}
			System.out.println(count);
		}
	}
}
