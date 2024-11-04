import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			List<String> list = new ArrayList<>();
			int amount = scanner.nextInt();
			for (int i = 0; i < amount; i++) {
				String next = scanner.next();
				if (!list.contains(next))
					list.add(next);
			}
			list.sort(Comparator.comparingInt(String::length)
					.thenComparing(Comparator.naturalOrder())
			);
			list.forEach(System.out::println);
		}
	}
}
