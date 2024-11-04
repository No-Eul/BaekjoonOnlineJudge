import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				OutputStreamWriter writer = new OutputStreamWriter(System.out)
		) {
			int[] array = new int[10001];
			for (int n = Integer.parseInt(reader.readLine()); n > 0; n--)
				array[Integer.parseInt(reader.readLine())]++;
			for (int i = 0; i < array.length; i++) {
				while (array[i]-- > 0) {
					writer.write(String.valueOf(i));
					writer.write('\n');
				}
			}
			writer.flush();
		}
	}
}
