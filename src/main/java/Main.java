import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		try (InputStreamReader reader = new InputStreamReader(System.in)) {
			int c = 0xAC00 + "ㄱㄲㄴㄷㄸㄹㅁㅂㅃㅅㅆㅇㅈㅉㅊㅋㅌㅍㅎ".indexOf(reader.read()) * 588;
			reader.read();
			c += (reader.read() - 0x314F) * 28;
			reader.read();
			c += "ㄱㄲㄳㄴㄵㄶㄷㄹㄺㄻㄼㄽㄾㄿㅀㅁㅂㅄㅅㅆㅇㅈㅊㅋㅌㅍㅎ".indexOf(reader.read()) + 1;
			System.out.println((char) c);
		}
	}
}
