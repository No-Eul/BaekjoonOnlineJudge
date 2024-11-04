import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int inputs = scanner.nextInt(), direction = scanner.nextInt() - 1;
			Map<Character, char[]> map = new HashMap<Character, char[]>() {{
				this.put('b', new char[]{ 'p', 'd' });
				this.put('d', new char[]{ 'q', 'b' });
				this.put('p', new char[]{ 'b', 'q' });
				this.put('q', new char[]{ 'd', 'p' });
			}};
			while (inputs-- > 0) {
				for (char c : scanner.next().toCharArray())
					System.out.print(map.get(c)[direction]);
				System.out.println();
			}
		}
	}
}
