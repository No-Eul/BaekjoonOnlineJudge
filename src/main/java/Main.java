import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			double a = scanner.nextInt(), b = scanner.nextInt(),
					c = scanner.nextInt(), d = scanner.nextInt();
			double[] array = { a / c + b / d, c / d + a / b, d / b + c / a, b / a + d / c };
			int indexMax = 0;
			for (int i = 1; i < array.length; i++) {
				if (array[i] > array[indexMax])
					indexMax = i;
			}
			System.out.println(indexMax);
		}
	}
}
