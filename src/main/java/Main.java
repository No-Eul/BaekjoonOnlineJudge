import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), sum = n * (m - 1);
			List<Integer> list = new ArrayList<>();
			while (m-- > 0) {
				list.add(scanner.nextInt());
				scanner.next();
			}
			list.sort(null);
			for (int i = list.size(); i > 1; sum -= Math.min(list.get(--i), n));
			System.out.println(sum);
		}
	}
}
