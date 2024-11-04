import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in).useDelimiter("[^A-Za-z-]+")) {
			String longest = "";
			while (scanner.hasNext("[A-Za-z-]+")) {
				String next = scanner.next("[A-Za-z-]+");
				if (next.length() > longest.length())
					longest = next;
			}
			System.out.println(longest.toLowerCase());
		}
	}
}
