import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws URISyntaxException {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			for (int i = 1; i <= n; i++) {
				URI uri = new URI(scanner.next());
				System.out.printf("URL #%d%n%-8s = %s%n%-8s = %s%n%-8s = %s%n%-8s = %s%n%n", i,
						"Protocol", uri.getScheme(),
						"Host", uri.getHost(),
						"Port", uri.getPort() < 0 ? "<default>" : uri.getPort(),
						"Path", uri.getRawPath().isEmpty() ? "<default>" : uri.getRawPath().substring(1)
				);
			}
		}
	}
}
