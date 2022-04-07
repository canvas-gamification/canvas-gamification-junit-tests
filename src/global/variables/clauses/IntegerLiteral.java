package global.variables.clauses;

import global.exceptions.InvalidClauseException;
import global.utils.RegexUtil;
import global.variables.Clause;

import static global.utils.RegexUtil.orNegative;

public class IntegerLiteral extends Clause {
    private String mode;
    public static final String RANGE = "range";
    public static final String VALUE = "value";
    int value;
    int upper;
    int lower;


    public IntegerLiteral() {
        super();
        this.mode = RANGE;
        this.lower = Integer.MIN_VALUE;
        this.upper = Integer.MAX_VALUE;
    }

    public IntegerLiteral(String name) {
        super(name);
        this.mode = RANGE;
        this.lower = Integer.MIN_VALUE;
        this.upper = Integer.MAX_VALUE;
    }

    public IntegerLiteral(int value) {
        super();
        this.mode = VALUE;
        this.value = value;
    }

    public IntegerLiteral(int value, String name) {
        super(name);
        this.mode = VALUE;
        this.value = value;
    }

    public IntegerLiteral(int lower, int upper) {
        super();
        this.mode = RANGE;
        this.lower = lower;
        this.upper = upper;
    }

    public IntegerLiteral(int lower, int upper, String name) {
        super(name);
        this.mode = RANGE;
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
        if (this.mode != null && this.mode.equals(IntegerLiteral.RANGE)) {
            int matchGroupInt = Integer.parseInt(matchGroupString);
            return getLower() <= matchGroupInt && matchGroupInt <= getUpper();
        }
        return true;
    }

    @Override
    public void validateParams() throws InvalidClauseException {
        if (this.mode != null && this.mode.equals(IntegerLiteral.RANGE)) {
            if (getLower() > getUpper()) {
                throw new InvalidClauseException("Lower bound cannot be greater than upper bound");
            }
        }
    }

    public String getValueOrRegexRange() {
        if (this.mode != null && this.mode.equals(IntegerLiteral.RANGE)) {
            return RegexUtil.getRegexInt(getLower(), getUpper());
        } else {
            return String.valueOf(getValue());
        }
    }

    @Override
    public String getRegex() {
        return "(" + orNegative(getValueOrRegexRange()) + ")";
    }
}
