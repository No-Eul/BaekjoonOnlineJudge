import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print(scanner.next().length() < scanner.next().length() ? "no" : "go");
		}
	}
}
