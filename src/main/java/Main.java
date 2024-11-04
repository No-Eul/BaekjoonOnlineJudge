import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			if (scanner.hasNext("\\p{Lower}+(\\p{Upper}\\p{Lower}*)*")) {
				scanner.useDelimiter("(?=\\p{Upper})");
				while (scanner.hasNext()) {
					System.out.print(scanner.next().toLowerCase());
					if (scanner.hasNext())
						System.out.print('_');
				}
			} else if (scanner.hasNext("\\p{Lower}+(_\\p{Lower}+)*")) {
				scanner.useDelimiter("_");
				System.out.print(scanner.next());
				while (scanner.hasNext()) {
					String next = scanner.next();
					System.out.append(Character.toUpperCase(next.charAt(0)))
							.print(next.substring(1));
				}
			} else System.out.println("Error!");
		}
	}
}
