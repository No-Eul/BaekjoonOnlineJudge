import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(factorial(1, scanner.nextInt()));
		}
	}

	public static BigInteger factorial(int start, int end) {
		if (end - start < 1)
			return BigInteger.valueOf(start);
		if (end - start == 1)
			return BigInteger.valueOf(start).multiply(BigInteger.valueOf(end));
		int mid = (start + end) / 2;
		return factorial(start, mid).multiply(factorial(mid + 1, end));
	}
}
