import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			BigInteger divisor = scanner.nextBigInteger();
			System.out.println(scanner.nextBigInteger()
					.subtract(scanner.nextBigInteger())
					.divide(divisor)
			);
		}
	}
}
