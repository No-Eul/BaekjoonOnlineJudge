import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		try (InputStreamReader reader = new InputStreamReader(System.in)) {
			int read = reader.read() - 0xAC00;
			System.out.println("ㄱㄲㄴㄷㄸㄹㅁㅂㅃㅅㅆㅇㅈㅉㅊㅋㅌㅍㅎ".charAt(read / 588));
			System.out.println((char) (read / 28 % 21 + 0x314F));
			if (read % 28 != 0)
				System.out.println("ㄱㄲㄳㄴㄵㄶㄷㄹㄺㄻㄼㄽㄾㄿㅀㅁㅂㅄㅅㅆㅇㅈㅊㅋㅌㅍㅎ".charAt((read - 1) % 28));
		}
	}
}
