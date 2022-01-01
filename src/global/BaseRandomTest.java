package global;

import global.variables.Regexable;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public abstract class BaseRandomTest extends BaseTest {
    static ArrayList<Set<Integer>> randomIntegerSets = new ArrayList<>();
    static ArrayList<Set<Double>> randomDoubleSets = new ArrayList<>();

    // TODO: choose number
    @RepeatedTest(500)
    public void testRandomNumbers(String patternRegex, int lowerBound, int upperBound, RepetitionInfo repetitionInfo, int... regexGroupIndexes) {
        Regexable[] regexSentence = getRegexSentence();


        if (repetitionInfo.getCurrentRepetition() == repetitionInfo.getTotalRepetitions()) {
            // TODO: inefficient as it runs through all sets for each call on the last repetition - this can be better
            for (Set<Integer> randomIntegerSet : randomIntegerSets) {
                assertNotEquals(1, randomIntegerSet.size(), "You do not seem to be properly generating random values.");
            }
            for (Set<Double> randomDoubleSet : randomDoubleSets) {
                assertNotEquals(1, randomDoubleSet.size(), "You do not seem to be properly generating random values.");
            }
        }
    }
}
