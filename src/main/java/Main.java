import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Set<Integer> list = new HashSet<>();
			for (int i = 0; i < 10; i++)
				list.add(scanner.nextInt() % 42);
			System.out.println(list.size());
		}
	}
}
