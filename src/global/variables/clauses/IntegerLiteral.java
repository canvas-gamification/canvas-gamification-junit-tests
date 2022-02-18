package global.variables.clauses;

import global.utils.RegexUtil;
import global.variables.Clause;

public class IntegerLiteral extends Clause {
    int value;
    int upper;
    int lower;

    public IntegerLiteral(int value) {
        super();
        this.value = value;
        this.upper = value;
        this.lower = value;

    }

    public IntegerLiteral(int value, String name) {
        super(name);
        this.value = value;
        this.upper = value;
        this.lower = value;
    }

    public IntegerLiteral(int lower, int upper) {
        super();
        this.value = 0;
        this.lower = lower;
        this.upper = upper;
    }

    public IntegerLiteral(int lower, int upper, String name) {
        super(name);
        this.value = 0;
        this.lower = lower;
        this.upper = upper;
    }

    public int getUpper() {
        return upper;
    }

    public int getLower() {
        return lower;
    }

    public int getValue() {
        return value;
    }

    public String getValueOrRegexRange() {
        if (getLower() == getUpper()) {
            return String.valueOf(getValue());
        } else if (getLower() > getUpper()) {
            //TODO: I'm not sure if having a default like this is a good idea, or if I should put it into the constructor
            return RegexUtil.getRegexInt(1, 999999);
        } else {
            return RegexUtil.getRegexInt(getLower(), getUpper());
        }
    }

    @Override
    public String getRegex() {
        return "(" + getValueOrRegexRange() + ")";
    }
}
