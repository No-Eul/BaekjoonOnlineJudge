import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int a = System.in.read(), b = System.in.read();
		System.out.printf("%c%c%c", System.in.read(), b, a);
	}
}
