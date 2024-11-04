import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int t = scanner.nextInt(); t > 0; t--) {
				Set<Character> set = new HashSet<>();
				int sum = 2015;
				for (char c : scanner.next().toCharArray()) {
					if (set.contains(c)) continue;
					set.add(c);
					sum -= c;
				}
				System.out.println(sum);
			}
		}
	}
}
