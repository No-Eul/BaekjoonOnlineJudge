import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Set<Integer> set = new HashSet<>();
			int n = scanner.nextInt();
			for (int i = 0; i < n; i++)
				set.add(scanner.nextInt());
			int m = scanner.nextInt();
			for (int i = 0; i < m; i++)
				System.out.println(set.contains(scanner.nextInt()) ? 1 : 0);
		}
	}
}
