import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int seconds = 0;
			while (scanner.hasNext())
				seconds += scanner.nextInt();
			System.out.printf("%d%n%d", seconds / 60, seconds % 60);
		}
	}
}
