import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int sum = 0;
			for (int i = 0; i++ < 5; sum += Math.max(scanner.nextInt(), 40));
			System.out.println(sum / 5);
		}
	}
}
