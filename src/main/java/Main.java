import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String string = scanner.next();
			System.out.println(string.equals("SONGDO") ? "HIGHSCHOOL"
					: string.equals("CODE") ? "MASTER"
					: string.equals("2023") ? "0611"
					: string.equals("ALGORITHM") ? "CONTEST" : 0
			);
		}
	}
}
