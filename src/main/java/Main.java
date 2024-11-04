import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt() - 8;
			System.out.println(
					n < 0 || n > 18 ? "Impossible" : new String[]{
							"11:11", "11:17", "11:14", "11:12", "11:01",
							"11:07", "11:04", "11:02", "11:00", "11:08",
							"17:08", "14:08", "12:08", "01:08", "07:08",
							"04:08", "02:08", "00:08", "08:08"
					}[n]
			);
		}
	}
}
