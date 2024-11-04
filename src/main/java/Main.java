import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			BigInteger x = BigInteger.ONE;
			for (int i = n - k; i < n; x = x.multiply(BigInteger.valueOf(++i)));
			while (k > 1) x = x.divide(BigInteger.valueOf(k--));
			System.out.println(x);
		}
	}
}
