import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Map<Map.Entry<Integer, Integer>, Integer> map = new HashMap<>();
			int students = scanner.nextInt(), teammates = scanner.nextInt(), teams = 0;
			while (students-- > 0)
				map.merge(new AbstractMap.SimpleEntry<>(scanner.nextInt(), scanner.nextInt()), 1, Integer::sum);
			for (double value : map.values())
				teams += Math.ceil(value / teammates);
			System.out.println(teams);
		}
	}
}
