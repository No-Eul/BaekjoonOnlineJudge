import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String word;
			while (!(word = scanner.next()).equals("#")){
				int differences = 0, words = 0;
				String nextWord;
				while (!(nextWord = scanner.next()).equals("#")) {
					for (int i = 0; nextWord.length() == word.length() && i < nextWord.length(); i++) {
						if (nextWord.charAt(i) != word.charAt(i))
							differences++;
					}
					word = nextWord;
					words++;
				}
				System.out.println(differences == words ? "Correct" : "Incorrect");
			}
		}
	}
}
