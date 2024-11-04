import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int lines = 0;
			for (; scanner.hasNextLine(); lines++) scanner.nextLine();
			System.out.println(lines);
		}
	}
}
