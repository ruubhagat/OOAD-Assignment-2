import formatters.BoldFormatter;
import formatters.ItalicsFormatter;
import formatters.TextFormatter;
import formatters.UnderlineFormatter;
import models.Word;
import models.WordStyle;
import models.WordType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Setup the formatter chain
        TextFormatter boldFormatter = new BoldFormatter();
        TextFormatter italicsFormatter = new ItalicsFormatter();
        TextFormatter underlineFormatter = new UnderlineFormatter();

        boldFormatter.setNextFormatter(italicsFormatter);
        italicsFormatter.setNextFormatter(underlineFormatter);

        // Create some words with different styles and types
        List<Word> words = new ArrayList<>();
        words.add(new Word("The", 0, WordType.ADJECTIVE, WordStyle.BOLD));
        words.add(new Word("quick", 1, WordType.ADJECTIVE, WordStyle.ITALICS));
        words.add(new Word("brown", 2, WordType.ADJECTIVE, WordStyle.UNDERLINE));
        words.add(new Word("fox", 3, WordType.NOUN, WordStyle.BOLD));
        words.add(new Word("jumps", 4, WordType.VERB, WordStyle.ITALICS));
        words.add(new Word("over", 5, WordType.VERB, WordStyle.UNDERLINE));
        words.add(new Word("the", 6, WordType.ADJECTIVE, WordStyle.BOLD));
        words.add(new Word("lazy", 7, WordType.ADJECTIVE, WordStyle.ITALICS));
        words.add(new Word("dog.", 8, WordType.NOUN, WordStyle.UNDERLINE));

        // Sort words by position
        words.sort(Comparator.comparingInt(Word::getPosition));

        // Display word details
        System.out.println("\nWord Details:");

        // Display formatted sentence
        System.out.println("\nFormatted Sentence:");
        StringBuilder sentence = new StringBuilder();
        for (Word word : words) {
            // Apply the formatting chain
            String formattedWord = boldFormatter.format(word);
            sentence.append(formattedWord).append(" ");
        }
        System.out.println(sentence.toString().trim());

        // Display ANSI-colored output word by word (more compatible approach)
        System.out.println("\nStyled Console Output (using ANSI):");
        for (Word word : words) {
            String text = word.getText();
            switch (word.getStyle()) {
                case BOLD:
                    System.out.print("\033[1m" + text + "\033[0m ");
                    break;
                case ITALICS:
                    System.out.print("\033[3m" + text + "\033[0m ");
                    break;
                case UNDERLINE:
                    System.out.print("\033[4m" + text + "\033[0m ");
                    break;
                default:
                    System.out.print(text + " ");
            }
        }
        System.out.println(); // Add a newline at the end
    }
}