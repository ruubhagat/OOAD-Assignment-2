package formatters;

import models.Word;
import models.WordStyle;

public class ItalicsFormatter extends TextFormatter {
    @Override
    public String format(Word word) {
        if (word.getStyle() == WordStyle.ITALICS) {
            return "<i>" + word.getText() + "</i>";
        } else if (nextFormatter != null) {
            return nextFormatter.format(word);
        }
        return word.getText();
    }
}