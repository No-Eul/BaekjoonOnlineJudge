import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int max = 0, index = 0;
			for (int i = 1; scanner.hasNextInt(); i++) {
				int next = scanner.nextInt();
				if (next > max) {
					max = next;
					index = i;
				}
			}
			System.out.println(max);
			System.out.println(index);
		}
	}
}
