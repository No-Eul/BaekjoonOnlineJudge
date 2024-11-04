import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int place = scanner.nextInt() - 1;
			System.out.printf("%d %d",
					new int[]{ 12, 11, 11, 10, 9, 9, 9, 8, 7, 6, 6 }[place],
					new int[]{ 1600, 894, 1327, 1311, 1004, 1178, 1357, 837, 1055, 556, 773 }[place]
			);
		}
	}
}
