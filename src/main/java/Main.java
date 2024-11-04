import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < 50; i++)
				list.add(scanner.nextInt());
			int index = list.indexOf(scanner.nextInt());
			System.out.println(index < 5 ? "A+"
					: index < 15 ? "A0"
					: index < 30 ? "B+"
					: index < 35 ? "B0"
					: index < 45 ? "C+"
					: index < 48 ? "C0"
					: "F"
			);
		}
	}
}
