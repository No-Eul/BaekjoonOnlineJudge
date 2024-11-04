import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int even = 0, odd = 0;
			for (int i = scanner.nextInt(); i > 0; i--) {
				if (scanner.nextInt() % 2 == 0) even++;
				else odd++;
			}
			System.out.println(even > odd ? "Happy" : "Sad");
		}
	}
}
