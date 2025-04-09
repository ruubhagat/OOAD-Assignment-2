package formatters;

import models.Word;
import models.WordStyle;

public class BoldFormatter extends TextFormatter {
    @Override
    public String format(Word word) {
        if (word.getStyle() == WordStyle.BOLD) {
            return "<b>" + word.getText() + "</b>";
        } else if (nextFormatter != null) {
            return nextFormatter.format(word);
        }
        return word.getText();
    }
}