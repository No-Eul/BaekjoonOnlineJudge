import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int time = scanner.nextInt();
			System.out.println(time < 12 || time > 16 || scanner.nextInt() != 0 ? 280 : 320);
		}
	}
}
