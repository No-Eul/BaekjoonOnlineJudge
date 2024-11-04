import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int c = System.in.read();
		System.out.println(c == 'M' ? "MatKor"
				: c == 'W' ? "WiCys"
				: c == 'C' ? "CyKor"
				: c == 'A' ? "AlKor"
				: c == '$' ? "$clear" : 0
		);
	}
}
