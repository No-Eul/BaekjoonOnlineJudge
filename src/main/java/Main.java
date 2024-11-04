import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println((1 << n) - 1);
			StringBuilder builder = new StringBuilder();
			move(builder, n, 1, 3, 2);
			System.out.println(builder);
		}
	}

	public static void move(StringBuilder builder, int current, int src, int dest, int temp) {
		if (current < 2) {
			builder.append(src).append(' ').append(dest).append('\n');
			return;
		}
		move(builder, current - 1, src, temp, dest);
		move(builder, 0, src, dest, temp);
		move(builder, current - 1, temp, dest, src);
	}
}
