package global.utils;

import global.variables.Clause;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    public static String processRegexForPrintlnOutput(String regexPattern) {
        return regexPattern + "\\R";
    }

    public static Matcher getMatches(String outputString, String patternString) {
        return Pattern.compile(patternString).matcher(outputString);
    }

    public static String combineRegex(Clause[] clauses) {
        StringBuilder combinedRegex = new StringBuilder();
        for (Clause clause : clauses) {
            combinedRegex.append(clause.getRegex());
        }
        return combinedRegex.toString();
    }

    public static String getRegexInt(int lower, int upper) {
        int minDigits = String.valueOf(lower).length();
        int maxDigits = String.valueOf(upper).length();

        return String.format("\\d{%d,%d}", minDigits, maxDigits);
    }

    public static int[] getSplitDecimal(double num) {
        String[] lowSplit = String.valueOf(num).split("\\.");
        return new int[]{Integer.parseInt(lowSplit[0]), Integer.parseInt(lowSplit[1])};
    }
}
