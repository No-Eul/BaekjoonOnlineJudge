import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int min = Integer.MAX_VALUE, max = 0;
			for (int n = scanner.nextInt(); n > 0; n--) {
				int p = scanner.nextInt();
				if (p < min) min = p;
				if (p > max) max = p;
			}
			System.out.println(Math.max(min - max / 2, 0));
		}
	}
}
