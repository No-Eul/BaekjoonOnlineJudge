import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(
					new Calculator(
							new Generator(
									new Parser(
											new Tokenizer(scanner.nextLine()).tokenize()
									).parse()
							).generate()
					).calculate()
			);
		} catch (Exception e) {
			System.out.println("ROCK");
		}
	}
}
