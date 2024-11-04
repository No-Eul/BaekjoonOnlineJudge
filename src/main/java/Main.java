import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int c;
		while ((c = System.in.read()) >= 0) {
			for (int i = 0; i < c / 100 + c / 10 % 10 + c % 10; i++)
				System.out.print((char) c);
			System.out.print('\n');
		}
	}
}
