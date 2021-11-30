package global;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepetitionInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class BaseRandomTest extends BaseTest {
    /*
    Doesn't account for the student using random correctly, but using a range smaller than the proper range
     */
    static ArrayList<Set<Integer>> randomIntegerSets = new ArrayList<>();
    static ArrayList<Set<Double>> randomDoubleSets = new ArrayList<>();

    @BeforeAll
    public static void initialize() {
    } // initialize random number sets

    public static void initializeRandomIntegers(int... regexGroupIndexes) {
        for (int i: regexGroupIndexes)
            randomIntegerSets.add(new HashSet<>());
    }

    public static void initializeRandomDoubles(int... regexGroupIndexes) {
        for (int i: regexGroupIndexes)
            randomDoubleSets.add(new HashSet<>());
    }

    public void testRandomNumberRange(int min, int max, int... randomNumbers) {
        for (int randomNumber : randomNumbers) {
            assertTrue(randomNumber >= min && randomNumber < max, "One or more of your randomly generated numbers fall outside of the required range.");
        }
    }

    public void testRandomNumberRange(double min, double max, double... randomNumbers) {
        for (double randomNumber : randomNumbers) {
            assertTrue(randomNumber >= min && randomNumber < max, "One or more of your randomly generated numbers fall outside of the required range.");
        }
    }

    public void testRandomIntegersHelper(String patternRegex, int lowerBound, int upperBound, RepetitionInfo repetitionInfo, int... regexGroupIndexes) {
        Matcher matcher = getMatches(getOutput(), patternRegex);

        if (matcher.find()) {
            for (int i = 0; i < regexGroupIndexes.length; i++) {
                int regexGroupNum = regexGroupIndexes[i];
                int randomNum = Integer.parseInt(matcher.group(regexGroupNum));
                randomIntegerSets.get(i).add(randomNum);
                testRandomNumberRange(lowerBound, upperBound, randomNum);
            }
        }

        if (repetitionInfo.getCurrentRepetition() == repetitionInfo.getTotalRepetitions()) {
            // TODO: inefficient as it runs through all sets for each call on the last repetition - this can be better
            for (Set<Integer> randomIntegerSet : randomIntegerSets) {
                assertNotEquals(1, randomIntegerSet.size(), "You do not seem to be properly generating random values.");
            }
        }
    }

    public void testRandomDoublesHelper(String patternRegex, int lowerBound, int upperBound, RepetitionInfo repetitionInfo, int... regexGroupIndexes) {
        Matcher matcher = getMatches(getOutput(), patternRegex);

        if (matcher.find()) {
            for (int i = 0; i < regexGroupIndexes.length; i++) {
                int regexGroupNum = regexGroupIndexes[i];
                double randomNum = Double.parseDouble(matcher.group(regexGroupNum));
                randomDoubleSets.get(i).add(randomNum);
                testRandomNumberRange(lowerBound, upperBound, randomNum);
            }
        }

        if (repetitionInfo.getCurrentRepetition() == repetitionInfo.getTotalRepetitions()) {
            // TODO: inefficient as it runs through all sets for each call on the last repetition - this can be better
            for (Set<Double> randomDoubleSet : randomDoubleSets) {
                assertNotEquals(1, randomDoubleSet.size(), "You do not seem to be properly generating random double values.");
                boolean foundDoubleValue = false;
                for (double d : randomDoubleSet) {
                    // Check that the random double values are not all just integers
                    double diff = d - (int) d;
                    foundDoubleValue = diff != 0;
                    if (foundDoubleValue) break;
                }
                assertTrue(foundDoubleValue, "You do not seem to be properly generating random double values.");
            }
        }
    }
}
