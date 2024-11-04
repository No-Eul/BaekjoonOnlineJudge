import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int n = scanner.nextInt() / 4; n > 0; n--)
				System.out.print("long ");
			System.out.println("int");
		}
	}
}
