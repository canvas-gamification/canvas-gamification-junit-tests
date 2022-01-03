package global.variables;

import global.utils.RandomUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomDouble implements Regexable, RandomVariable<Double> {
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

    public void addValueToMapListHelper(HashMap<Integer, ?> map, int mapKey, Object newListValue) {
        ((ArrayList<Double>) map.get(mapKey)).add((double) newListValue);
    }

    public ArrayList<Double> createArrayList() {
        return new ArrayList<>();
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
