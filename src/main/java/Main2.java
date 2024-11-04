import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main2 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(IntStream.range(0, scanner.nextInt())
					.mapToObj(i -> new AbstractMap.SimpleEntry<>(scanner.nextInt(), scanner.nextInt()))
					.filter(e -> e.getKey() <= e.getValue())
					.min(Map.Entry.comparingByValue())
					.map(Map.Entry::getValue)
					.orElse(-1)
			);
		}
	}
}
