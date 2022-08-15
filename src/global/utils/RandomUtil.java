package global.utils;

import global.variables.*;
import org.apache.commons.math3.stat.inference.ChiSquareTest;

import java.util.ArrayList;
import java.util.Arrays;

import static global.tools.CustomAssertions.assertWithinRange;

public class RandomUtil {
    /*
    Note: not guaranteed to fail cases where delta(user range, expected range) is small
     */
    public static final int NO_BIN = -1;
    public static final double ALPHA_LEVEL = 0.12;
    /**
     * This constant is the ratio of bin frequencies that must be within the range for the group of bin frequencies to be
     * considered to represent a random set
     */
    public static final double ACCEPTANCE_RATE = 0.90;

    /**
     * Returns if the set of values described by the total number of values considered and an array of "bin sizes" is
     * uniform. "Bin counts" refers to the number of values that are placed in each bin. This method assumes that the
     * size (range) of each bin is equal.
     *
     * @param numValues:   Total number of values in the set.
     * @param binSizes:    The number of values that are placed in each equally-sized bin.
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

    public static RandomClause<?> castRandomClause(Clause clause) {
        if (!(clause instanceof RandomClause)) return null;
        return (RandomClause<?>) clause;
    }

    /**
     * Determine if a list of frequencies is random
     *
     * @param frequencies a list of frequency counts for bins
     * @return whether this array of frequencies describes randomly generated values
     */
    public static boolean frequenciesAreRandom(int[] frequencies, int numBins) {
        // assume that the sum of frequencies in this list == the total number of values generated
        double expectedFrequency = ArrayUtil.sum(frequencies) * 1.0 / numBins;
        int count = 0;
        for (int frequency : frequencies) {
            // TODO: calculate percentage error based on total values and number of bins
            // Checks if each bin is within 50% of the expected value
            if (valueAlmostEquals(frequency, expectedFrequency, 0.50))
                count++;
        }
        // If the number of bins which pass the randomness check is above the acceptance rate, the numbers are considered random
        return (count * 1.0) / numBins >= ACCEPTANCE_RATE;
    }

    public static boolean valueAlmostEquals(double value, double target, double percentageError) {
        double upperBound = Math.ceil(target + target * percentageError);
        double lowerBound = Math.floor(target - target * percentageError);
        return lowerBound <= value && value <= upperBound;
    }
}
