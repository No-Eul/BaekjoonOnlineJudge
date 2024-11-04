import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = 0;
			for (int n = scanner.nextInt(), b = 1, temp;
					n-- > 0;
					temp = a, a += b, b = temp
			);
			System.out.println(a);
		}
	}
}
