import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			for (int i = scanner.nextInt(); i > 0; i--) {
				String string = scanner.next();
				System.out.println(string.equals("Algorithm") ? 204
						: string.equals("DataAnalysis") ? 207
						: string.equals("ArtificialIntelligence") ? 302
						: string.equals("CyberSecurity") ? "B101"
						: string.equals("Network") ? 303
						: string.equals("Startup") ? 501
						: string.equals("TestStrategy") ? 105 : 0
				);
			}
		}
	}
}
