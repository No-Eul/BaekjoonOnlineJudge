import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in).useDelimiter("-")) {
			while (scanner.hasNext())
				System.out.print(scanner.next().charAt(0));
		}
	}
}
