package global.variables;

public class StringLiteral implements Clause {
    String text;

    public StringLiteral(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String getRegex() {
        return "(" + getText() + ")";
    }
}
