import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt();
			String operator;
			while (!(operator = scanner.next()).equals("=")) {
				switch (operator) {
					case "+": x += scanner.nextInt(); break;
					case "-": x -= scanner.nextInt(); break;
					case "*": x *= scanner.nextInt(); break;
					case "/": x /= scanner.nextInt(); break;
				}
			}
			System.out.println(x);
		}
	}
}
