package global.variables.wrappers;

import global.variables.Regexable;

public class Optional implements Regexable {
    Regexable regexable;
    int lower, upper;
    boolean zeroOrOne = true;

    public Optional(Regexable regexable) {
        this.regexable = regexable;
    }

    public Optional(Regexable regexable, int lower, int upper) {
        this.regexable = regexable;
        this.zeroOrOne = false;
        this.lower = lower;
        this.upper = upper;
    }

    public boolean isZeroOrOne() {
        return zeroOrOne;
    }

    public Regexable getVariableNode() {
        return regexable;
    }

    public int getUpper() {
        return upper;
    }

    public int getLower() {
        return lower;
    }

    @Override
    public String getRegex() {
        String modifier = isZeroOrOne() ? "?" : "{" + getLower() + "," + getUpper() + "}";
        return getVariableNode().getRegex() + modifier;
    }
}
