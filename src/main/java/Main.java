import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int hypot = scanner.nextInt(), height = scanner.nextInt(), width = scanner.nextInt();
			System.out.printf("%d %d",
					(int) (height * hypot / Math.hypot(width, height)),
					(int) (width * hypot / Math.hypot(width, height))
			);
		}
	}
}
