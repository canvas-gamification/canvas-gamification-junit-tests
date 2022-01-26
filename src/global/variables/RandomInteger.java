package global.variables;

import global.utils.RandomUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RandomInteger implements Clause, RandomVariable<Integer> {
    static Map<Integer, ArrayList<Integer>> valueStore = new HashMap<>();
    private int lower, upper;

    public RandomInteger(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public int getNumBins(double lower, double upper) {
        int range = (int) (upper - lower);
        return Math.min(range, 50);
    }

    public void trackValue(int groupNum, String groupValue) {
        valueStore.computeIfAbsent(groupNum, k -> new ArrayList<>());

        (valueStore.get(groupNum)).add(convertFromRegexGroup(groupValue));
    }

    public boolean validateRandom(int groupNum) {
        if (valueStore.get(groupNum) == null)
            return false;
        ArrayList<Integer> values = valueStore.get(groupNum);
        return followsUniformDistribution(values, getLower(), getUpper());
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
