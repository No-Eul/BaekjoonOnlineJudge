import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int place = scanner.nextInt();
			System.out.printf("%d%nA %sC %s%sF G H %sL M",
					place < 5 ? place < 2 ? 11 : 9 : 8,
					place == 1 || place == 4 || place == 10 ? "B " : "",
					place == 1 ? "D " : "",
					place > 9 ? "" : "E ",
					place < 2 ? "J " : place < 4 ? "I " : ""
			);
		}
	}
}
