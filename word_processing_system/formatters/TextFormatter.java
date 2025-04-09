package formatters;

import models.Word;

public class TextFormatter {
    protected TextFormatter nextFormatter;

    public void setNextFormatter(TextFormatter formatter) {
        this.nextFormatter = formatter;
    }

    public String format(Word word) {
        if (nextFormatter != null) {
            return nextFormatter.format(word);
        }
        // Default case: return the text as is if no formatter matches
        return word.getText();
    }
}