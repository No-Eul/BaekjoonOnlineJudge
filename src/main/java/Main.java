import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int balance = 0;
			while (n-- > 0) {
				switch (scanner.nextInt()) {
					case 136: balance += 1; break;
					case 142: balance += 5; break;
					case 148: balance += 10; break;
					case 154: balance += 50; break;
				}
				scanner.next();
			}
			System.out.println(balance * 1000);
		}
	}
}
