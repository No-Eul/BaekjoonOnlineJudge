import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int i = 1; !scanner.nextLine().equals("0"); i++)
				System.out.printf("Case %d: Sorting... done!%n", i);
		}
	}
}
