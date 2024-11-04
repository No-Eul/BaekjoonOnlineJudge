import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String based = scanner.next();
			System.out.print(Integer.parseInt(based, scanner.nextInt()));
		}
	}
}
