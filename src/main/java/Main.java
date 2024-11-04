import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int lines = scanner.nextInt();
			scanner.nextLine();
			for (int i = 1; i <= lines; i++) {
				StringBuilder builder = new StringBuilder();
				for (String word : scanner.nextLine().split(" "))
					builder.insert(0, word).insert(0, ' ');
				System.out.printf("Case #%d:%s%n", i, builder);
			}
		}
	}
}
