package global.variables;

import org.apache.commons.math3.stat.inference.ChiSquareTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public interface RandomVariable<T> {
    int NO_BIN = -1;
    double ALPHA_LEVEL = 0.05;

    void trackValue(int groupNum, String newListValue);

    boolean validateRandom(int groupNum);

    T convertFromRegexGroup(String groupValue);

    int getNumBins(double lower, double upper);

    default boolean followsUniformDistribution(ArrayList<T> values, double lower, double upper) {

        final int NUM_BINS = getNumBins(lower, upper);

        long[] observedCounts = new long[NUM_BINS];
        for (T value : values) {
            int binNum = assignedBinNum(value, lower, upper, NUM_BINS);
            if (binNum == NO_BIN) return false;
            observedCounts[binNum]++;
        }

        double[] expected = new double[NUM_BINS];
        int expectedFreq = values.size() / NUM_BINS;
        Arrays.fill(expected, expectedFreq);

        ChiSquareTest cst = new ChiSquareTest();
        // function returns false if we fail to reject null hypothesis, which implies the values are uniformly distributed
        return !cst.chiSquareTest(expected, observedCounts, ALPHA_LEVEL);
    }

    default int assignedBinNum(T value, double lower, double upper, int numBins) {
        double range = upper - lower;
        double gap = range / numBins;
        double v = Double.parseDouble(value.toString());

        assertWithinRange(v, lower, upper, "One or more of your randomly generated numbers fall outside of the required range.");
        int binNumber = (int) ((v - lower) / gap);
        return (binNumber <= numBins) ? binNumber : NO_BIN;
    }

    default void assertWithinRange(double value, double lower, double upper, String message) {
        // TODO: is message too specific / giving away too much?
        assertTrue(lower <= value && value < upper, message);
    }
}
