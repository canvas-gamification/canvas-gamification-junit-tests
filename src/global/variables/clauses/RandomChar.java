package global.variables.clauses;

import global.variables.Clause;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static global.utils.RandomUtil.followsUniformDistribution;

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
        ArrayList<Integer> intValues = new ArrayList<>();
        for (char c : values) {
            intValues.add((int) c);
        }
        return followsUniformDistribution(intValues, getLower(), getUpper());
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
    public String getRegex() {
        String regex = "[" + (char) getLower() + "-" + (char) getUpper() + "]";
        return "(" + regex + ")";
    }
}
