import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNext()) {
				if (!scanner.next().matches("0|1")) {
					System.out.println("F");
					return;
				}
			}
			System.out.println("S");
		}
	}
}
