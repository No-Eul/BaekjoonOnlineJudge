import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			IntStream.range(0, scanner.nextInt())
					.mapToObj(i -> scanner.next())
					.distinct()
					.sorted(Comparator.comparingInt(String::length)
							.thenComparing(Comparator.naturalOrder())
					)
					.forEach(System.out::println);
		}
	}
}
