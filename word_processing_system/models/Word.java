package models;

import formatters.TextFormatter;

public class Word {
    private String text;
    private int position;
    private WordType type;
    private WordStyle style;

    public Word(String text, int position, WordType type, WordStyle style) {
        this.text = text;
        this.position = position;
        this.type = type;
        this.style = style;
    }

    public String getText() {
        return text;
    }

    public int getPosition() {
        return position;
    }

    public WordType getType() {
        return type;
    }

    public WordStyle getStyle() {
        return style;
    }

    public String getStylizedWord() {
        // This will use the formatter chain to style the word
        return new TextFormatter().format(this);
    }

    @Override
    public String toString() {
        return "Word{text='" + text + "', position=" + position +
                ", type=" + type + ", style=" + style + "}";
    }
}