import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			scanner.nextLine();
			while (t-- > 0) {
				int sum = 0;
				for (String s : scanner.nextLine().split(" "))
					sum += Integer.parseInt(s);
				System.out.println(sum);
			}
		}
	}
}
