import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int p = scanner.nextInt(), q = scanner.nextInt(), s = scanner.nextInt();
			for (int a = p, b = q; p != q && (p + a <= s || q + b <= s); ) {
				if (p < q) p += a;
				else q += b;
			}
			System.out.println(p == q && p <= s ? "yes" : "no");
		}
	}
}
