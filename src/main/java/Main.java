import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int n = Integer.parseInt(scanner.nextLine()); n > 0; n--) {
				if (!scanner.nextLine().matches("Never gonna (give you up|let you down|run around and desert you|make you cry|say goodbye|tell a lie and hurt you|stop)")) {
					System.out.println("Yes");
					return;
				}
			}
			System.out.println("No");
		}
	}
}
