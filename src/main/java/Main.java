import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int sum = 0;
			while (scanner.hasNext())
				sum += scanner.nextInt();
			System.out.println(sum);
		}
	}
}
