import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			BigInteger n = scanner.nextBigInteger(), m = scanner.nextBigInteger();
			System.out.printf("%d %d", n.divide(m), n.mod(m));
		}
	}
}
