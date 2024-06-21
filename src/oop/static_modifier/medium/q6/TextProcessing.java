package oop.static_modifier.medium.q6;

public class TextProcessing {
    private static String indicator = ", eh";
    private String text;

    public TextProcessing(String t) {
        text = t;
    }

    public String localize() {
        return text + indicator;
    }

    public String extractLocalizations() {
        return text.replaceAll(indicator, "");
    }
}

