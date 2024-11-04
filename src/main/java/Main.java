import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			List<Integer> list = new ArrayList<>();
			while (scanner.hasNext())
				list.add(scanner.nextInt());
			list.sort(null);
			System.out.println(list.get(1));
		}
	}
}
