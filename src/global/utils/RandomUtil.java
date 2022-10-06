package global.utils;

import global.tools.Logger;
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
    public static final double ACCEPTANCE_RATE = 0.75;

    /**
     * This constant is the percentage error each bin is allowed to stray from the calculated median value. If the value
     * is greater than the target + target * PERCENTAGE_ERROR or is less than the target - target * PERCENTAGE_ERROR,
     * the bin falls outside the allowed range.
     */
    public static final double PERCENTAGE_ERROR = 0.25;

    /**
     * This constant is the maximum number of bins which will be used when determining if something is randomly
     * distributed.
     */
    public static final int MAX_BINS = 20;

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
        int binNumber = 10;
        while (range % binNumber != 0 && binNumber < MAX_BINS)
            binNumber++;
        return Math.min(range, binNumber);
    }

    public static int assignedBinIndex(int value, int lower, int upper, int numBins) {
        int range = upper - lower;
        double gap = (range * 1.0) / numBins;
        assertWithinRange(value, lower, upper, "One or more of your randomly generated numbers fall outside of the required range.");
        int binNumber = (int) Math.floor((value - lower) / gap);
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
            if (valueAlmostEquals(frequency, expectedFrequency, PERCENTAGE_ERROR))
                count++;
        }
        // If the number of bins which pass the randomness check is above the acceptance rate, the numbers are considered random
        return (count * 1.0) / numBins >= ACCEPTANCE_RATE;
    }

    public static boolean frequenciesAreRandom(int[] frequencies, double percentageTrue) {
        // This function is used exclusively for testing boolean randomness as the percentage error value is lower
        // than what is in the normal function and only one bin needs to be tested
        double expectedTrueFrequency = ArrayUtil.sum(frequencies) * percentageTrue;
        // Bins should be within 10% of the target frequency
        double errorAmount = 0.10;
        return valueAlmostEquals(frequencies[1], expectedTrueFrequency, errorAmount);
    }

    public static boolean valueAlmostEquals(double value, double target, double percentageError) {
        double upperBound = Math.ceil(target + target * percentageError);
        double lowerBound = Math.floor(target - target * percentageError);
        Logger.logMessage(String.format("Lower: %f Upper: %f", lowerBound, upperBound));
        return lowerBound <= value && value <= upperBound;
    }
}
