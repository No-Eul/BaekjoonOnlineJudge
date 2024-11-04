import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			BigInteger apples = scanner.nextBigInteger(),
					klaudia = scanner.nextBigInteger(),
					two = BigInteger.valueOf(2);
			System.out.printf("%d %d",
					apples.add(klaudia).divide(two),
					apples.subtract(klaudia).divide(two)
			);
		}
	}
}
