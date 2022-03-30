package global.utils;

import global.variables.Clause;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    public static String processRegexForPrintlnOutput(String regexPattern) {
        return regexPattern + "\\R?";
    }

    public static Matcher getMatches(String outputString, String patternString) {
        return Pattern.compile(patternString).matcher(outputString);
    }

    public static String combineRegex(Clause[] clauses) {
        StringBuilder combinedRegex = new StringBuilder();
        for (Clause clause : clauses) {
            if (clause.getRegex() != null) {
                combinedRegex.append(clause.getRegex());
            }
        }
        return combinedRegex.toString();
    }

    public static String orNegative(String regexString) {
        return "-?" + regexString;
    }

    public static String getRegexInt(int lower, int upper) {
        if (lower == Integer.MIN_VALUE && upper == Integer.MAX_VALUE) {
            return "\\d+";
        }

        int minDigits = String.valueOf(Math.abs(lower)).length();
        int maxDigits = String.valueOf(Math.abs(upper)).length();

        if(parity(lower) == -1 && parity(upper) == -1) {  // both negative parity
            // when both lower and upper are negative, the lower value has more digits, so we swap
            int tempMinDigits = minDigits;
            minDigits = maxDigits;
            maxDigits = tempMinDigits;
        }

        if (parity(lower) != parity(upper)) {  // if range spans from negative to positive values
            // 1 value is always possible around 0, and the largest digits possible on either side becomes the max
            maxDigits = Math.max(minDigits, maxDigits);
            minDigits = 1;
        }

        return String.format("\\d{%d,%d}", minDigits, maxDigits);
    }

    public static int[] getSplitDecimal(double num) {
        String[] lowSplit = String.valueOf(Math.abs(num)).split("\\.");
        return new int[]{Integer.parseInt(lowSplit[0]), Integer.parseInt(lowSplit[1])};
    }

    public static int parity(int value) {
        return value >= 0 ? 1 : -1;  // returns -1 if value is negative, 1 if value is positive or zero
    }
}
