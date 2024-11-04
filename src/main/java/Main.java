import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int size = scanner.nextInt();
			boolean[] a = new boolean[size * size],
					b = new boolean[size * size],
					result = new boolean[size * size];
			for (int i = 0; i < a.length; a[i++] = scanner.nextInt() != 0);
			for (int i = 0; i < b.length; b[i++] = scanner.nextInt() != 0);
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					for (int k = 0; k < size; k++)
						result[i * size + j] |= a[i * size + k] && b[k * size + j];
				}
			}
			int sum = 0;
			for (boolean bool : result)
				sum += bool ? 1 : 0;
			System.out.println(sum);
		}
	}
}
