import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder builder = new StringBuilder();
			while (scanner.hasNextLine())
				builder.append(scanner.nextLine());
			int n = 0;
			for (String string : builder.toString().split(","))
				n += Integer.parseInt(string);
			System.out.println(n);
		}
	}
}
