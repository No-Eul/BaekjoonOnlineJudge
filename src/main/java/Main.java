import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		byte[] buffer = new byte[8192];
		int reads;
		while ((reads = System.in.read(buffer)) > 0)
			System.out.write(buffer, 0, reads);
	}
}
