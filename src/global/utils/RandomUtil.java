package global.utils;

import global.variables.*;
import org.apache.commons.math3.stat.inference.ChiSquareTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomUtil {
    /*
    Note: not guaranteed to fail cases where delta(user range, expected range) is small
     */
    static final int NO_BIN = -1;
    static final double ALPHA_LEVEL = 0.12;

    public static String getRegexInt(int lower, int upper) {
        int minDigits = String.valueOf(lower).length();
        int maxDigits = String.valueOf(upper).length();

        return String.format("\\d{%d,%d}", minDigits, maxDigits);
    }

    public static int[] getSplitDecimal(double num) {
        String[] lowSplit = String.valueOf(num).split("\\.");
        return new int[]{Integer.parseInt(lowSplit[0]), Integer.parseInt(lowSplit[1])};
    }

    public static boolean followsUniformDistribution(ArrayList<Integer> values, int lower, int upper) {
        final int NUM_BINS = getNumBins(lower, upper);

        long[] observedCounts = new long[NUM_BINS];
        for (int value : values) {
            int binNum = assignedBinNum(value, lower, upper, NUM_BINS);
            if (binNum == NO_BIN) return false;
            observedCounts[assignedBinNum(value, lower, upper, NUM_BINS)]++;
        }

        double[] expected = new double[NUM_BINS];
        int expectedFreq = values.size() / NUM_BINS;
        Arrays.fill(expected, expectedFreq);

        ChiSquareTest cst = new ChiSquareTest();
        // function returns false if we fail to reject null hypothesis, which implies the values are uniformly distributed
        return !cst.chiSquareTest(expected, observedCounts, ALPHA_LEVEL);
    }

    public static boolean followsUniformDistribution(ArrayList<Double> values, double lower, double upper) {
        final int NUM_BINS = getNumBins(lower, upper);

        long[] observedCounts = new long[NUM_BINS];
        for (double value : values) {
            int binNum = assignedBinNum(value, lower, upper, NUM_BINS);
            if (binNum == NO_BIN) return false;
            observedCounts[assignedBinNum(value, lower, upper, NUM_BINS)]++;
        }

        double[] expected = new double[NUM_BINS];
        int expectedFreq = values.size() / NUM_BINS;
        Arrays.fill(expected, expectedFreq);

        ChiSquareTest cst = new ChiSquareTest();
        // function returns false if we fail to reject null hypothesis, which implies the values are uniformly distributed
        return !cst.chiSquareTest(expected, observedCounts, ALPHA_LEVEL);
    }

    public static int assignedBinNum(double value, int lower, int upper, int numBins) {
        int range = upper - lower;
        return assignedBinNumHelper(range, value, lower, upper, numBins);
    }

    public static int assignedBinNum(double value, double lower, double upper, int numBins) {
        double range = upper - lower;
        return assignedBinNumHelper(range, value, lower, upper, numBins);
    }

    public static int assignedBinNumHelper(double range, double value, double lower, double upper, int numBins) {
        double gap = range / numBins;

        assertWithinRange(value, lower, upper, "One or more of your randomly generated numbers fall outside of the required range.");

        int binNumber = (int) ((value - lower) / gap);

        return (binNumber <= numBins) ? binNumber : NO_BIN;
    }

    public static int getNumBins(int lower, int upper) {
        int range = upper - lower;
        return getNumBinsHelper(range);
    }

    public static int getNumBins(double lower, double upper) {
        return 50;  // TODO: check constant number of buckets for doubles
    }

    public static int getNumBinsHelper(int range) {
        return Math.min(range, 50);
    }

    public static void assertWithinRange(double value, double lower, double upper, String message) {
        // TODO: is message too specific / giving away too much?
        assertTrue(lower <= value && value < upper, message);
    }
}