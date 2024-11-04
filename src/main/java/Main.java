import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
	public static void main(String[] args) throws IOException {
		try (Reader reader = new InputStreamReader(System.in)) {
			System.out.println(reader.read());
		}
	}
}
