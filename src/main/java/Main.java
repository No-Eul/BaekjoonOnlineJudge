import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String string = scanner.next();
			IntStream.range(0, string.length())
					.mapToObj(string::substring)
					.sorted()
					.forEach(System.out::println);
		}
	}
}
