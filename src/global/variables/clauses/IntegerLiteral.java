package global.variables.clauses;

import global.tools.InvalidClauseException;
import global.utils.RegexUtil;
import global.variables.Clause;

import java.util.HashMap;
import java.util.Map;

public class IntegerLiteral extends Clause {
    private Map<String, Boolean> MODES;
    int value;
    int upper;
    int lower;

    public void initalizeModeMap() {
        this.MODES = new HashMap<>();
    }

    public IntegerLiteral() {
        super();
        initalizeModeMap();
        this.MODES.put("RANGE", true);
        this.lower = Integer.MIN_VALUE;
        this.upper = Integer.MAX_VALUE;
    }

    public IntegerLiteral(String name) {
        super(name);
        initalizeModeMap();
        this.MODES.put("RANGE", true);
        this.lower = Integer.MIN_VALUE;
        this.upper = Integer.MAX_VALUE;
    }

    public IntegerLiteral(int value) {
        super();
        initalizeModeMap();
        this.MODES.put("VALUE", true);
        this.value = value;
    }

    public IntegerLiteral(int value, String name) {
        super(name);
        initalizeModeMap();
        this.MODES.put("VALUE", true);
        this.value = value;
    }

    public IntegerLiteral(int lower, int upper) {
        super();
        initalizeModeMap();
        this.MODES.put("RANGE", true);
        this.lower = lower;
        this.upper = upper;
    }

    public IntegerLiteral(int lower, int upper, String name) {
        super(name);
        initalizeModeMap();
        this.MODES.put("RANGE", true);
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
        if (this.MODES.get("RANGE") != null && this.MODES.get("RANGE")) {
            int matchGroupInt = Integer.parseInt(matchGroupString);
            return getLower() <= matchGroupInt && matchGroupInt <= getUpper();
        }
        return true;
    }

    @Override
    public void validateParams() throws InvalidClauseException {
        if (this.MODES.get("RANGE") != null && this.MODES.get("RANGE")) {
            if (getLower() > getUpper()) {
                throw new InvalidClauseException("Lower bound cannot be greater than upper bound");
            }
        }
    }

    public String getValueOrRegexRange() {
        if (this.MODES.get("RANGE") != null && this.MODES.get("RANGE")) {
            return RegexUtil.getRegexInt(getLower(), getUpper());
        } else {
            return String.valueOf(getValue());
        }
    }

    @Override
    public String getRegex() {
        return "(" + getValueOrRegexRange() + ")";
    }
}
