package global.utils;

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
