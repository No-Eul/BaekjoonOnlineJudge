import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int t = scanner.nextInt(); t > 0; t--)
				System.out.println(scanner.next().replaceAll("D.*", "").length());
		}
	}
}
