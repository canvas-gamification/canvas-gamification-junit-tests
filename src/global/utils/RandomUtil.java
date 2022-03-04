package global.utils;

import global.variables.*;
import org.apache.commons.math3.stat.inference.ChiSquareTest;

import java.util.ArrayList;
import java.util.Arrays;

import static global.tools.CustomAssertions.assertWithinRange;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomUtil {
    /*
    Note: not guaranteed to fail cases where delta(user range, expected range) is small
     */
    public static final int NO_BIN = -1;
    public static final double ALPHA_LEVEL = 0.12;

    /**
     * Returns if the set of values described by the total number of values considered and an array of "bin sizes" is
     * uniform. "Bin counts" refers to the number of values that are placed in each bin. This method assumes that the
     * size (range) of each bin is equal.
     * @param numValues: Total number of values in the set.
     * @param binSizes: The number of values that are placed in each equally-sized bin.
     * @param alpha_level: The alpha level specified for the Chi-Squared test
     * @return True if the described set is uniform
     */
    public static boolean describesUniform(int numValues, long[] binSizes, double alpha_level) {
        double[] expected = new double[binSizes.length];
        int expectedFreq = numValues / binSizes.length;
        Arrays.fill(expected, expectedFreq);
        ChiSquareTest cst = new ChiSquareTest();
        // function returns false if we fail to reject null hypothesis, which implies the values are uniformly distributed
        return !cst.chiSquareTest(expected, binSizes, alpha_level);
    }

    public static boolean followsUniformDistribution(ArrayList<Integer> values, int lower, int upper) {
        final int NUM_BINS = getNumBins(lower, upper);

        long[] observedCounts = new long[NUM_BINS];
        for (int value : values) {
            int binNum = assignedBinIndex(value, lower, upper, NUM_BINS);
            if (binNum == NO_BIN) return false;
            observedCounts[binNum]++;
        }

        return describesUniform(values.size(), observedCounts, ALPHA_LEVEL);
    }

    public static int getNumBins(int lower, int upper) {
        int range = upper - lower;
        return Math.min(range, 50);
    }

    public static int assignedBinIndex(int value, int lower, int upper, int numBins) {
        int range = upper - lower;
        double gap = (double) range / numBins;
        assertWithinRange(value, lower, upper, "One or more of your randomly generated numbers fall outside of the required range.");
        int binNumber = (int) ((value - lower) / gap);
        return (binNumber <= numBins) ? binNumber : NO_BIN;
    }
}
