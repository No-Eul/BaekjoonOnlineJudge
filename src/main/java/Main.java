import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in).useDelimiter("\\D+")) {
			List<BigInteger> list = new ArrayList<>();
			scanner.next();
			while (scanner.hasNext())
				list.add(scanner.nextBigInteger());
			list.sort(null);
			list.forEach(System.out::println);
		}
	}
}
