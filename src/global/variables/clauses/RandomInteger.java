package global.variables.clauses;

import global.utils.RegexUtil;
import global.variables.Clause;
import global.variables.RandomClause;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static global.utils.RandomUtil.*;
import static global.utils.RegexUtil.orNegative;

public class RandomInteger extends Clause implements RandomClause<Integer> {
    static Map<Integer, ArrayList<Integer>> valueStore = new HashMap<>();
    private final int lower, upper;
    public final Class<Integer> primitiveClass = Integer.class;
    public static int mapKey;

    public RandomInteger(int lower, int upper) {
        super();
        this.lower = lower;
        this.upper = upper;
    }

    public RandomInteger(int lower, int upper, String name) {
        super(name);
        this.lower = lower;
        this.upper = upper;
    }

    public void trackValue(int matchGroupNum, String matchGroupValue) {
        valueStore.computeIfAbsent(matchGroupNum, k -> new ArrayList<>());
        (valueStore.get(matchGroupNum)).add(convertFromRegexGroup(matchGroupValue));
    }

    public boolean validateRandom(int matchGroupNum) {
        if (valueStore.get(matchGroupNum) == null)
            return false;
        ArrayList<Integer> values = valueStore.get(matchGroupNum);
        final int NUM_BINS = getNumBins(lower, upper);
        int[] observedCounts = new int[NUM_BINS];
        for (int value : values) {
            int binNum = assignedBinIndex(value, lower, upper, NUM_BINS);
            if (binNum == NO_BIN) return false;
            observedCounts[binNum]++;
        }
        return frequenciesAreRandom(observedCounts, NUM_BINS);
    }

    public int getUpper() {
        return upper;
    }

    public int getLower() {
        return lower;
    }

    public Integer convertFromRegexGroup(String matchGroupString) {
        // TODO: try catch
        return Integer.parseInt(matchGroupString);
    }

    @Override
    public ArrayList<Integer> getValuesForMatchGroup(int matchGroup) {
        return valueStore.get(matchGroup);
    }

    public Class<Integer> getPrimitiveClass() {
        return primitiveClass;
    }

    @Override
    public String getRegex() {
        String regexContent = RegexUtil.getRegexInt(getLower(), getUpper());
        return "(" + orNegative(regexContent) + ")";
    }

    public int getMapKey(){
        return mapKey;
    }

    public void incrementMapKey(){
        mapKey++;
    }
}
