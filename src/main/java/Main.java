import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int amount = scanner.nextInt();
			scanner.nextLine();
			int result = 0;
			for (int i = 0; i < amount; i++)
				result += Integer.parseInt(scanner.findInLine("\\d"));
			System.out.println(result);
		}
	}
}
