import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), max = 0, sum = 0;
			int[] scores = new int[n];
			for (int i = n; i > 0; sum += scores[i]) {
				if ((scores[--i] = scanner.nextInt()) > max)
					max = scores[i];
			}
			System.out.println(sum * 100.0 / (max * scores.length));
		}
	}
}
