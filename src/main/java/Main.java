import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in).useDelimiter("\\W+")) {
			SortedMap<String, Integer> set = new TreeMap<>();
			int n = scanner.nextInt();
			while (n-- > 0) {
				scanner.next();
				set.merge(scanner.next(), 1, Integer::sum);
			}
			set.forEach((k, v) -> System.out.printf("%s %d%n", k, v));
		}
	}
}
