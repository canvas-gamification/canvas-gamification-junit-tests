package global.variables;

public class StringLiteral extends Clause {
    String text;

    public StringLiteral(String text) {
        super();
        this.text = text;
    }

    public StringLiteral(String text, String name) {
        super(name);
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
