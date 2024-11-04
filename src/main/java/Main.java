import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int sum = 0;
			for (char c : scanner.next().toCharArray())
				sum = (sum * 10 + c - '0') % 20000303;
			System.out.println(sum);
		}
	}
}
