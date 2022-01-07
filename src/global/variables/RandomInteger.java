package global.variables;

import global.utils.RandomUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomInteger implements Clause, RandomVariable<Integer> {
    private int lower, upper;

    public RandomInteger(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public void addValueToMapListHelper(HashMap<Integer, ?> map, int mapKey, Object newListValue) {
        ((ArrayList<Integer>) map.get(mapKey)).add((int) newListValue);
    }

    public ArrayList<Integer> createArrayList() {
        return new ArrayList<>();
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
