package global.variables;

public class RandomInteger implements VariableNode, RandomVariable {
    private int lower, upper;

    public RandomInteger(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public int getUpper() {
        return upper;
    }

    public int getLower() {
        return lower;
    }

    @Override
    public String getRegex() {
        return "(" + RandomUtil.getRegexInt(getLower(), getUpper()) + ")";
    }
}
