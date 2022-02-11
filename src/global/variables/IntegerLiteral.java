package global.variables;

public class IntegerLiteral extends Clause {
    int value;

    public IntegerLiteral(int value) {
        super();
        this.value = value;
    }

    public IntegerLiteral(int value, String name) {
        super(name);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String getRegex() {
        return "(" + getValue() + ")";
    }
}
