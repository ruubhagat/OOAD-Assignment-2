package formatters;

import models.Word;
import models.WordStyle;

public class UnderlineFormatter extends TextFormatter {
    @Override
    public String format(Word word) {
        if (word.getStyle() == WordStyle.UNDERLINE) {
            return "<u>" + word.getText() + "</u>";
        } else if (nextFormatter != null) {
            return nextFormatter.format(word);
        }
        return word.getText();
    }
}