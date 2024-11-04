import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder builder = new StringBuilder();
			int keywords = scanner.nextInt(), posts = scanner.nextInt();
			Set<String> keywordSet = new HashSet<>();
			while (keywords-- > 0)
				keywordSet.add(scanner.next());
			while (posts-- > 0) {
				for (String keyword : scanner.next().split(","))
					keywordSet.remove(keyword);
				builder.append(keywordSet.size()).append('\n');
			}
			System.out.println(builder);
		}
	}
}
