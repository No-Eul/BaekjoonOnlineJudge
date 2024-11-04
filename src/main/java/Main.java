import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), x = 0;
			Set<String> set = new HashSet<>();
			while (n-- > 0) set.add(scanner.next());
			while (m-- > 0) {
				if (set.contains(scanner.next())) x++;
			}
			System.out.println(x);
		}
	}
}
