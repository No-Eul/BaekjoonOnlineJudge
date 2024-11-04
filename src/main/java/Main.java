import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		System.out.printf("Naver %s", (System.in.read() - 78) % 32 == 0 ? "D2" : "Whale");
	}
}
