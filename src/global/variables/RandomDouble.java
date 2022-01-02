package global.variables;

import global.utils.RandomUtil;

public class RandomDouble implements Regexable, RandomVariable<Double> {
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

    public Double convertFromRegexGroup(String groupString) {
        // TODO: try catch
        return Double.parseDouble(groupString);
    }

    @Override
    public String getRegex() {
        int[] lowSplit = RandomUtil.getSplitDecimal(lower);
        int[] highSplit = RandomUtil.getSplitDecimal(upper);
        return "(" + RandomUtil.getRegexInt(lowSplit[0], highSplit[0]) + "\\." + RandomUtil.getRegexInt(lowSplit[1], highSplit[1]) + ")";
    }
}
