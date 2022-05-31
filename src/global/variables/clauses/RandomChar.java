package global.variables.clauses;

import global.variables.Clause;
import global.variables.RandomClause;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static global.utils.RandomUtil.*;

public class RandomChar extends Clause implements RandomClause<Character> {
    static Map<Integer, ArrayList<Character>> valueStore = new HashMap<>();
    public int lower, upper;

    public RandomChar(char lower, char upper) {
        super();
        this.lower = lower;
        this.upper = upper;
    }

    public RandomChar(char lower, char upper, String name) {
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
        ArrayList<Character> values = valueStore.get(matchGroupNum);
        final int NUM_BINS = getNumBins(lower, upper);
        int[] observedCounts = new int[NUM_BINS];
        for (int value : values) {
            int binNum = assignedBinIndex(value, lower, upper, NUM_BINS);
            if (binNum == NO_BIN) return false;
            observedCounts[binNum]++;
        }
        return frequenciesAreRandom(observedCounts, NUM_BINS);
    }

    public int getLower() {
        return lower;
    }

    public int getUpper() {
        return upper;
    }

    public Character convertFromRegexGroup(String matchGroupString) {
        if (matchGroupString.length() > 1) {
            // TODO: throw appropriate error for this case
            System.err.println("One of your inputs is not a valid character");
            throw new IndexOutOfBoundsException();
        }
        return matchGroupString.charAt(0);
    }

    @Override
    public ArrayList<Character> getValuesForMatchGroup(int matchGroup) {
        return valueStore.get(matchGroup);
    }

    @Override
    public String getRegex() {
        String regex = "[" + (char) getLower() + "-" + (char) getUpper() + "]";
        return "(" + regex + ")";
    }
}
