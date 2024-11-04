import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String next = scanner.nextLine();
			System.out.println(next.equals("1 2 3 4 5 6 7 8") ? "ascending"
					: next.equals("8 7 6 5 4 3 2 1") ? "descending"
					: "mixed"
			);
		}
	}
}
