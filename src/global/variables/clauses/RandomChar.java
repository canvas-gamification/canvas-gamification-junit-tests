package global.variables.clauses;

import global.variables.Clause;
import global.variables.RandomClause;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static global.tools.CustomAssertions._fail;
import static global.utils.RandomUtil.*;

public class RandomChar extends Clause implements RandomClause<Character> {
    static Map<Integer, ArrayList<Character>> valueStore = new HashMap<>();
    public int lower, upper;
    public boolean inclusiveUpper = false;

    // Soft deprecated - always favour using inclusiveUpper = true when possible
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

    public RandomChar(char lower, char upper, boolean inclusiveUpper) {
        this(lower, upper);
        if (inclusiveUpper) this.upper += 1;
        this.inclusiveUpper = inclusiveUpper;
    }

    public RandomChar(char lower, char upper, String name, boolean inclusiveUpper) {
        this(lower, upper, name);
        if (inclusiveUpper) this.upper += 1;
        this.inclusiveUpper = inclusiveUpper;
    }

    public void trackValue(int matchGroupNum, String matchGroupValue) {
        valueStore.computeIfAbsent(matchGroupNum, k -> new ArrayList<>());
        (valueStore.get(matchGroupNum)).add(convertFromRegexGroup(matchGroupValue));
    }

    public boolean validateRandom(int matchGroupNum) {
        if (valueStore.get(matchGroupNum) == null)
            return false;
        return validateRandom(valueStore.get(matchGroupNum));
    }

    public boolean validateRandom(ArrayList<Character> values) {
        if (values.size() < 1000)
            _fail("There is an error with the test definition. Please contact a test administrator.",
                    "Error: invalid number of values provided. There must be more than 1000 values generated"
            );

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

    public char getCorrectedUpper() {
        /*
        If inclusiveUpper = true, we would have increased this.upper by 1,
        so subtracting 1 returns it to its original value.

        If inclusiveUpper = false, then we want the regex to match up to
        the character before the char that this.upper represents, so we still subtract 1.
         */
        return (char) (upper - 1);
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
        String regex = "[" + (char) getLower() + "-" + getCorrectedUpper() + "]";
        return "(" + regex + ")";
    }
}
