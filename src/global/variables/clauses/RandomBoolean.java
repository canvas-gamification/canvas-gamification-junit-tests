package global.variables.clauses;

import global.variables.Clause;
import global.variables.RandomClause;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static global.utils.RandomUtil.frequenciesAreRandom;

public class RandomBoolean extends Clause implements RandomClause<Boolean> {
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
        // Note that the input boolean values are mapped to an Integer ArrayList with true = 1 and false = 0
        valueStore.computeIfAbsent(matchGroupNum, k -> new ArrayList<>());
        (valueStore.get(matchGroupNum)).add(convertFromRegexGroup(matchGroupValue) ? 1 : 0);
    }

    public boolean validateRandom(int matchGroupNum) {
        if (valueStore.get(matchGroupNum) == null)
            return false;
        ArrayList<Integer> values = valueStore.get(matchGroupNum);
        int[] observedCounts = new int[NUM_BINS];
        for (int value : values) {
            observedCounts[value]++;
        }
        return frequenciesAreRandom(observedCounts, percentageTrue);
    }

    public Boolean convertFromRegexGroup(String matchGroupString) {
        return Boolean.parseBoolean(matchGroupString);
    }

    public ArrayList<Boolean> getValuesForMatchGroup(int matchGroup) {
        // Maps Integer ArrayList back to the input boolean values to be displayed in the event of an error
        return valueStore.get(matchGroup).stream().map(e -> (e == 1) ).collect( Collectors.toCollection( ArrayList::new ) );
    }

    public String getRegex() {
        return "((?:true)|(?:false))";
    }
}
