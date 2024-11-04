import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int length = scanner.nextInt();
			System.out.println(length < 425 ? "Violet"
					: length < 450 ? "Indigo"
					: length < 495 ? "Blue"
					: length < 570 ? "Green"
					: length < 590 ? "Yellow"
					: length < 620 ? "Orange"
					: "Red"
			);
		}
	}
}
