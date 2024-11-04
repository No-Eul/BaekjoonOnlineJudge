import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0)
				System.out.println(scanner.next().matches("(100+1+|01)+") ? "YES" : "NO");
		}
	}
}
