import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt())
				System.out.println(scanner.nextInt() + scanner.nextInt());
		}
	}
}
