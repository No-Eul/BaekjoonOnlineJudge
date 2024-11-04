import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(IntStream.range(0, scanner.nextInt() + scanner.nextInt())
					.map(i -> scanner.nextInt())
					.sorted()
					.mapToObj(Integer::toString)
					.collect(Collectors.joining(" "))
			);
		}
	}
}
