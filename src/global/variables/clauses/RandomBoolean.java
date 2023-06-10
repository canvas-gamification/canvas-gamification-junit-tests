package global.variables.clauses;

import global.variables.Clause;
import global.variables.RandomClause;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static global.tools.CustomAssertions._fail;
import static global.utils.RandomUtil.frequenciesAreRandom;
import static org.junit.jupiter.api.Assertions.fail;

public class RandomBoolean extends Clause implements RandomClause<Object> {
    static Map<Integer, ArrayList<Integer>> valueStore = new HashMap<>();
    private final double percentageOutput1 = 0.5;
    private final String output1;
    private final String output2;

    private final int NUM_BINS = 2;

    public RandomBoolean() {
        super();
        output1 = "true";
        output2 = "false";
    }

    public RandomBoolean(String name) {
        super(name);
        output1 = "true";
        output2 = "false";
    }

    public RandomBoolean(String output1, String output2) {
        super();
        this.output1 = output1;
        this.output2 = output2;
    }

    public RandomBoolean(String output1, String output2, String name) {
        super(name);
        this.output1 = output1;
        this.output2 = output2;
    }

    public void trackValue(int matchGroupNum, String matchGroupValue) {
        // Note that the input boolean values are mapped to an Integer ArrayList with true = 1 and false = 0
        valueStore.computeIfAbsent(matchGroupNum, k -> new ArrayList<>());
        (valueStore.get(matchGroupNum)).add(convertFromRegexGroup(matchGroupValue));
    }

    public boolean validateRandom(int matchGroupNum) {
        if (valueStore.get(matchGroupNum) == null)
            return false;
        return this.validateRandomInts(valueStore.get(matchGroupNum));
    }

    public boolean validateRandomInts(ArrayList<Integer> values) {
        if (values.size() < 1000)
            _fail("There is an error with the test definition. Please contact a test administrator.",
                    "Error: invalid number of values provided. There must be more than 1000 values generated"
            );

        int[] observedCounts = new int[NUM_BINS];
        for (int value : values) {
            observedCounts[value]++;
        }
        return frequenciesAreRandom(observedCounts, percentageOutput1);
    }

    public boolean validateRandom(ArrayList<String> values) {
        if (values.size() < 1000)
            _fail("There is an error with the test definition. Please contact a test administrator.",
                    "Error: invalid number of values provided. There must be more than 1000 values generated"
            );

        int[] observedCounts = new int[NUM_BINS];
        for (String value : values) {
            if (value.equals(output1))
                observedCounts[1]++;
            else if (value.equals(output2))
                observedCounts[0]++;
            else
                fail("One of your randomly generated values was not one of the accepted inputs. Please make sure that you are generating values correctly.");
        }

        return frequenciesAreRandom(observedCounts, percentageOutput1);
    }

    public Integer convertFromRegexGroup(String matchGroupString) {
        return matchGroupString.equals(output1) ? 1 : 0;
    }

    public ArrayList<Object> getValuesForMatchGroup(int matchGroup) {
        // Maps Integer ArrayList back to the input values to be displayed in the event of an error
        return valueStore.get(matchGroup).stream().map(e -> (e == 1 ? output1 : output2)).
                collect(Collectors.toCollection(ArrayList::new));
    }

    public String getRegex() {
        return "((?:" + output1 + ")|(?:" + output2 + "))";
    }
}
