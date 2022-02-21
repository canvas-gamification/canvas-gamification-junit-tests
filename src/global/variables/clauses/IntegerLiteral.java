package global.variables.clauses;

import global.utils.RegexUtil;
import global.variables.Clause;

public class IntegerLiteral extends Clause {
    int value = 0;
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
        this.lower = lower;
        this.upper = upper;
    }

    public IntegerLiteral(int lower, int upper, String name) {
        super(name);
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

    @Override
    public boolean validate(String matchGroupString) {
        if (getLower() != getUpper()) {
            int matchGroupInt = Integer.parseInt(matchGroupString);
            return matchGroupInt >= getLower() && matchGroupInt <= getUpper();
        }
        return true;
    }

    @Override
    public boolean validateParams() {
        if (getLower() != getUpper()) {
            return getLower() < getUpper();
        }
        return true;
    }

    public String getValueOrRegexRange() {
        if (getLower() == getUpper()) {
            return String.valueOf(getValue());
        } else {
            return RegexUtil.getRegexInt(getLower(), getUpper());
        }
    }

    @Override
    public String getRegex() {
        return "(" + getValueOrRegexRange() + ")";
    }
}
