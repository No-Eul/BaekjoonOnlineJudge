import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			List<Integer> humans = new ArrayList<>();
			for (int i = 0; i < 4; i++)
				humans.add(scanner.nextInt());
			System.out.println(humans.indexOf(scanner.nextInt()) + 1);
		}
	}
}
