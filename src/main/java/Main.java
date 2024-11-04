import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			while (n-- > 0)
				System.out.println(scanner.next().matches(".{6,9}") ? "yes" : "no");
		}
	}
}
