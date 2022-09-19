package global.variables.clauses;

import global.variables.Clause;
import global.variables.RandomClause;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static global.utils.RandomUtil.frequenciesAreRandom;

public class RandomBoolean extends Clause implements RandomClause<Integer> {
    static Map<Integer, ArrayList<Integer>> valueStore = new HashMap<>();
    private final double percentageTrue;

    private final int NUM_BINS = 2;

    public RandomBoolean(){
        super();
        this.percentageTrue = 0.5;
    }

    public RandomBoolean(String name){
        super(name);
        this.percentageTrue = 0.5;
    }

    public RandomBoolean(double percentageTrue){
        super();
        this.percentageTrue = percentageTrue;
    }

    public RandomBoolean(double percentageTrue, String name){
        super(name);
        this.percentageTrue = percentageTrue;
    }

    public void trackValue(int matchGroupNum, String matchGroupValue) {
        valueStore.computeIfAbsent(matchGroupNum, k -> new ArrayList<>());
        (valueStore.get(matchGroupNum)).add(convertFromRegexGroup(matchGroupValue));
    }

    public boolean validateRandom(int matchGroupNum) {
        if (valueStore.get(matchGroupNum) == null)
            return false;
        ArrayList<Integer> values = valueStore.get(matchGroupNum);
        int[] observedCounts = new int[NUM_BINS];
        for (int value : values) {
            observedCounts[value]++;
        }
        return frequenciesAreRandom(observedCounts, NUM_BINS);
    }

    public Integer convertFromRegexGroup(String matchGroupString) {
        return Boolean.parseBoolean(matchGroupString) ? 1 : 0;
    }

    public ArrayList<Integer> getValuesForMatchGroup(int matchGroup) {
        return valueStore.get(matchGroup);
    }

    public String getRegex() {
        return "((?:true)|(?:false))";
    }
}
