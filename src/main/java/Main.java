import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int count = 0;
			for (; scanner.hasNext(); count++)
				scanner.next();
			System.out.println(count);
		}
	}
}
