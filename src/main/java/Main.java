import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Set<String> set = new TreeSet<>();
			while (scanner.hasNext())
				set.add(scanner.next());
			for (String a : set) {
				for (String b : set)
					System.out.printf("%s %s%n", a, b);
			}
		}
	}
}
