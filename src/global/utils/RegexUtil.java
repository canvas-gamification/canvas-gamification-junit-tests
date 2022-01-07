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

    public static String combineRegex(Clause[] regexVariables) {
        StringBuilder combinedRegex = new StringBuilder();
        for (Clause item : regexVariables) {
            combinedRegex.append(item.getRegex());
        }
        return combinedRegex.toString();
    }
}
