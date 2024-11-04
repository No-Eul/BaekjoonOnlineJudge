import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(Integer.parseInt(scanner.next()
					.replace('5', '4')
					.replace('6', '5')
					.replace('7', '6')
					.replace('8', '7')
					.replace('9', '8'), 9
			));
		}
	}
}
