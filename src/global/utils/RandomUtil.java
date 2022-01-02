package global.utils;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomUtil {
    public static String getRegexInt(int lower, int upper) {
        int minDigits = String.valueOf(lower).length();
        int maxDigits = String.valueOf(upper).length();

        return String.format("\\d{%d,%d}", minDigits, maxDigits);
    }

    public static int[] getSplitDecimal(double num) {
        String[] lowSplit = String.valueOf(num).split("\\.");
        return new int[]{Integer.parseInt(lowSplit[0]), Integer.parseInt(lowSplit[1])};
    }

    public static void testRandomNumbers(ArrayList<Integer> values, int lower, int upper) {
        final double SIG_LEVEL = 0.95;
        final int NUM_BINS = getNumBins(lower, upper);
        // make bins
        long[][] counts = new long[NUM_BINS][NUM_BINS];
        // TODO: figure out how to perform uniformity test with chi squared library
        // put number in bins
        // create count 2d array
    }

    public static int assignedBinNum(int value, int lower, int upper, int numBins) {
        int NO_BIN = -1;

        int range = upper - lower;
        double gap = (double) range / numBins;
        double binLower = lower;
        int count = 0;

        if(value < lower || value >= upper) {
            return NO_BIN;
        }

        while(binLower < upper) {
            double binUpper = binLower + gap;
            if(binLower <= value && value < binUpper)
                return count;
            count++;
            binLower = binUpper;
        }

        return NO_BIN;  // fits into no bins
    }

    public static int getNumBins(int lower, int upper) {
        int range = upper - lower;
        if (range <= 20) {
            return 10;
        } else {
            // TODO: FIX
            return 10;
        }
    }

    public static void withinRange(int value, int lower, int upper) {
        // TODO: is message too specific / giving away too much?
        assertTrue(lower <= value && value < upper, "Random values outside of desired range.");
    }

    public static void testRandomNumberRange(int min, int max, int... randomNumbers) {
        for (int randomNumber : randomNumbers) {
            assertTrue(randomNumber >= min && randomNumber < max, "One or more of your randomly generated numbers fall outside of the required range.");
        }
    }

    public static void testRandomNumberRange(double min, double max, double... randomNumbers) {
        for (double randomNumber : randomNumbers) {
            assertTrue(randomNumber >= min && randomNumber < max, "One or more of your randomly generated numbers fall outside of the required range.");
        }
    }
}
