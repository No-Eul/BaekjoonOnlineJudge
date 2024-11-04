import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			List<Integer> list = new ArrayList<>();
			int sum = 0;
			while (scanner.hasNextInt()) {
				int next = scanner.nextInt();
				list.add(next);
				sum += next;
			}
			list.sort(null);
			System.out.println(sum / list.size());
			System.out.println(list.get(list.size() / 2));
		}
	}
}
