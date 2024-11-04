import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			BigInteger next;
			while (!(next = scanner.nextBigInteger()).equals(BigInteger.ZERO))
				System.out.println(next.mod(BigInteger.valueOf(42)).equals(BigInteger.ZERO) ? "PREMIADO" : "TENTE NOVAMENTE");
		}
	}
}
