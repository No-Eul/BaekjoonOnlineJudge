import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), minPrice = scanner.nextInt(), maxProfit = 0;
			while (n-- > 1) {
				int price = scanner.nextInt();
				if (price - minPrice > maxProfit)
					maxProfit = price - minPrice;
				if (price < minPrice)
					minPrice = price;
			}
			System.out.println(maxProfit);
		}
	}
}
