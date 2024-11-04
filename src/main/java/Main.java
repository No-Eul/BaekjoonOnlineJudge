import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int a = 2;
			while (n-- > 0) a = a * 2 - 1;
			System.out.println(a * a);
		}
	}
}
