package global.variables.clauses;

import global.utils.RegexUtil;
import global.variables.Clause;
import global.variables.RandomClause;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static global.utils.RandomUtil.followsUniformDistribution;
import static global.utils.RegexUtil.orNegative;

public class RandomInteger extends Clause implements RandomClause<Integer> {
    static Map<Integer, ArrayList<Integer>> valueStore = new HashMap<>();
    private int lower, upper;

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
        return followsUniformDistribution(values, getLower(), getUpper());
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
    public String getRegex() {
        String regexContent = RegexUtil.getRegexInt(getLower(), getUpper());
        return "(" + orNegative(regexContent) + ")";
    }
}
