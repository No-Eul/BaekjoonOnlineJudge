import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] chars = scanner.next().toCharArray();
			for (int t = scanner.nextInt(); t > 0; t--) {
				int a = scanner.nextInt(), b = scanner.nextInt();
				char tmp = chars[a];
				chars[a] = chars[b];
				chars[b] = tmp;
			}
			System.out.println(chars);
		}
	}
}
