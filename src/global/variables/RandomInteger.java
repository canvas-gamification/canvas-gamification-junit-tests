package global.variables;

import global.utils.RandomUtil;

public class RandomInteger implements Regexable, RandomVariable<Integer> {
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

    public Integer convertFromRegexGroup(String groupString) {
        // TODO: try catch
        return Integer.parseInt(groupString);
    }

    @Override
    public String getRegex() {
        return "(" + RandomUtil.getRegexInt(getLower(), getUpper()) + ")";
    }
}
