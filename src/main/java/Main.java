import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int male, female;
			while ((male = scanner.nextInt()) * (female = scanner.nextInt()) > 0)
				System.out.println(male + female);
		}
	}
}
