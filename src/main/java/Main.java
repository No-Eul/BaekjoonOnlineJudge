import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = 0, b = 1, temp;
			for (int n = scanner.nextInt(); n-- > 0; temp = a, a += b, b = temp);
			System.out.println(a);
		}
	}
}
