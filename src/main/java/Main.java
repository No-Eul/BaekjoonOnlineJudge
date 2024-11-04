import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int length = scanner.nextInt(), sum = 0;
			List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
			for (int i = 0; i < length; i++)
				a.add(scanner.nextInt());
			for (int i = 0; i < length; i++)
				b.add(scanner.nextInt());
			a.sort(null);
			b.sort(null);
			for (int i = 0; i < length; sum += a.get(i) * b.get(length - ++i));
			System.out.println(sum);
		}
	}
}
