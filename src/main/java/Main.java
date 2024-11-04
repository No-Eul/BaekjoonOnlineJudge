import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		try (InputStreamReader reader = new InputStreamReader(System.in)) {
			char[] chars = new char[10];
			int reads;
			while ((reads = reader.read(chars)) >= 0)
				System.out.println(new String(chars, 0, reads));
		}
	}
}
