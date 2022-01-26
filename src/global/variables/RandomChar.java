package global.variables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RandomChar implements Clause, RandomVariable<Character> {
    static Map<Integer, ArrayList<Character>> valueStore = new HashMap<>();
    public int lower, upper;

    public RandomChar(char lower, char upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public RandomChar(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public int getNumBins(double lower, double upper) {
        int range = (int) (upper - lower);
        return Math.min(range, 50);
    };

    public void trackValue(int groupNum, String groupValue) {
        if (valueStore.get(groupNum) == null)
            valueStore.put(groupNum, new ArrayList<>());

        (valueStore.get(groupNum)).add(convertFromRegexGroup(groupValue));
    }

    public boolean validateRandom(int groupNum) {
        if (valueStore.get(groupNum) == null)
            return false;
        ArrayList<Character> values = valueStore.get(groupNum);
        return followsUniformDistribution(values, getLower(), getUpper());
    }

    @Override
    public int assignedBinNum(Character value, double lower, double upper, int numBins) {
        double range = upper - lower;
        double gap = range / numBins;
        double v = (int) value;

        assertWithinRange(v, lower, upper, "One or more of your randomly generated numbers fall outside of the required range.");
        int binNumber = (int) ((v - lower) / gap);
        return (binNumber <= numBins) ? binNumber : NO_BIN;
    }

    public int getLower() {
        return lower;
    }

    public int getUpper() {
        return upper;
    }

    public Character convertFromRegexGroup(String groupString) {
        if(groupString.length() > 1) {
            // TODO: throw appropriate error for this case
            throw new IndexOutOfBoundsException();
        }
        return groupString.charAt(0);
    }

    @Override
    public String getRegex() {
        String regex = "[" + (char)getLower() + "-" + (char)getUpper() + "]";
        return "(" + regex + ")";
    }
}
