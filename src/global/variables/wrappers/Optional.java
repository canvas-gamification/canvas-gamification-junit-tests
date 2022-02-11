package global.variables.wrappers;

import global.variables.Clause;

public class Optional extends Clause {
    Clause clause;
    int lower, upper;
    boolean zeroOrOne = true;

    public Optional(Clause clause) {
        this.clause = clause;
    }

    public Optional(Clause clause, int lower, int upper) {
        this.clause = clause;
        this.zeroOrOne = false;
        this.lower = lower;
        this.upper = upper;
    }

    public boolean isZeroOrOne() {
        return zeroOrOne;
    }

    public Clause getVariableNode() {
        return clause;
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
