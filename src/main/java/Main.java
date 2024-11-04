import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int sum = 0;
			for (int i = scanner.nextInt(); i > 0; i--)
				sum += scanner.nextInt();
			System.out.println(sum);
		}
	}
}
