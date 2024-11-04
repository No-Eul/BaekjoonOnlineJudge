import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int t = scanner.nextInt(); t > 0; t--) {
				int div = scanner.nextInt(), digits = scanner.nextInt(),
						count = 0, x = 0, y = 0;
				int[] z = new int[div];
				for (int i = 0; i < digits; i++)
					x = x * 10 + scanner.nextInt();
				for (int i = 0; i < digits; i++)
					y = y * 10 + scanner.nextInt();
				for (int i = 0; i < div; z[i++] = scanner.nextInt());
				for (int i = 0; i < div; i++) {
					int number = 0;
					for (int j = 0; j < digits; j++)
						number = number * 10 + z[(i + j) % div];
					if (number < x || number > y)
						continue;
					count++;
				}
				System.out.println(count);
			}
		}
	}
}
