package global.variables;

import global.utils.RandomUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RandomDouble implements Clause, RandomVariable<Double> {
    static Map<Integer, ArrayList<Double>> valueStore = new HashMap<>();
    private double lower, upper;
    private int precision = 16;  // max double precision

    public RandomDouble(double lower, double upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public RandomDouble(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public RandomDouble(double lower, double upper, int precision) {
        this.lower = lower;
        this.upper = upper;
        this.precision = precision;
    }

    public RandomDouble(int lower, int upper, int precision) {
        this.lower = lower;
        this.upper = upper;
        this.precision = precision;
    }

    public int getNumBins(double lower, double upper) {
        return 50;  // TODO: do properly
    };

    public void trackValue(int groupNum, String groupValue) {
        if (valueStore.get(groupNum) == null)
            valueStore.put(groupNum, new ArrayList<>());

        (valueStore.get(groupNum)).add(convertFromRegexGroup(groupValue));
    }

    public boolean validateRandom(int groupNum) {
        if (valueStore.get(groupNum) == null)
            return false;
        ArrayList<Double> values = valueStore.get(groupNum);
        return followsUniformDistribution(values, getLower(), getUpper());
    }

    public double getLower() {
        return lower;
    }

    public double getUpper() {
        return upper;
    }

    public double getPrecision() {
        return precision;
    }

    public Double convertFromRegexGroup(String groupString) {
        // TODO: try catch
        return Double.parseDouble(groupString);
    }

    @Override
    public String getRegex() {
        int[] lowSplit = RandomUtil.getSplitDecimal(lower);
        int[] highSplit = RandomUtil.getSplitDecimal(upper);
        return "(" + RandomUtil.getRegexInt(lowSplit[0], highSplit[0]) + "\\.\\d+" + ")";
    }
}
