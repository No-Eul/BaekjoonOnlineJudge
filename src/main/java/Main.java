import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = 0;
			while (scanner.hasNextInt())
				n += scanner.nextInt();
			System.out.println(n);
		}
	}
}
