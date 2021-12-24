package global.randomframework;

public class RandomDouble implements VariableNode, RandomVariable {
    private double lower, upper;

    public RandomDouble(double lower, double upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public RandomDouble(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public double getLower() {
        return lower;
    }

    public double getUpper() {
        return upper;
    }

    @Override
    public String getRegex() {
        return RandomUtil.getRegexInt();
    }
}
