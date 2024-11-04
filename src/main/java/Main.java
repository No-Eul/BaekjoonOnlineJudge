import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Map<Integer, List<String>> map = new TreeMap<>();
			for (int n = scanner.nextInt(); n > 0; n--) {
				map.computeIfAbsent(scanner.nextInt(), k -> new ArrayList<>())
						.add(scanner.next());
			}
			map.forEach((age, list) -> list.forEach(name -> System.out.printf("%d %s%n", age, name)));
		}
	}
}
