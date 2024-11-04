import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			boolean[] infections = new boolean[scanner.nextInt()];
			int count = infections.length;
			for (int i = scanner.nextInt(), index; i > 0; i--) {
				switch (scanner.next()) {
					case "1":
						index = scanner.nextInt() - 1;
						if (!infections[index])
							count--;
						infections[index] = true;
						break;
					case "2":
						index = scanner.nextInt() - 1;
						if (infections[index])
							count++;
						infections[index] = false;
						break;
					case "3":
						System.out.println(count);
						break;
				}
			}
		}
	}
}
