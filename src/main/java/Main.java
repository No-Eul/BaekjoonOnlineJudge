import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Map<Character, Integer> map = new HashMap<>();
			for (int n = scanner.nextInt(); n > 0; n--) {
				int next = scanner.nextInt();
				char key = next < 1 ? ' ' : (char) (next + (next < 27 ? 'A' - 1 : 'a' - 27));
				map.merge(key, 1, Integer::sum);
			}
			for (char c : scanner.useDelimiter("\n").next().toCharArray()) {
				if (map.getOrDefault(c, 0) == 0) {
					System.out.println('n');
					return;
				}
				map.put(c, map.get(c) - 1);
			}
			System.out.println('y');
		}
	}
}
