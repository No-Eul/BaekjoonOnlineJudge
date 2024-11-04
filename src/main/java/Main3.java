import java.util.Scanner;
import java.util.StringTokenizer;

public class Main3 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(new StringTokenizer(scanner.nextLine()).countTokens());
		}
	}
}
