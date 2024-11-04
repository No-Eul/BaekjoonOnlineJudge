import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] string, chars;
			for (int i = 1; !Arrays.equals((string = scanner.next().toCharArray()), "END".toCharArray()); i++) {
				chars = scanner.next().toCharArray();
				Arrays.sort(string);
				Arrays.sort(chars);
				System.out.printf("Case %d: %s%n", i, Arrays.equals(string, chars) ? "same" : "different");
			}
		}
	}
}
