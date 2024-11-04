import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			double next;
			while ((next = scanner.nextDouble()) > 0)
				System.out.printf("Objects weighing %.2f on Earth will weigh %.2f on the moon.%n", next, next * 0.167);
		}
	}
}
