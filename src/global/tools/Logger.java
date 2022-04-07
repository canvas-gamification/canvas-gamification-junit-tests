package global.tools;

import global.variables.Clause;

import java.io.PrintStream;

import static global.utils.RegexUtil.combineRegex;
import static global.utils.RegexUtil.processRegexForPrintlnOutput;

public class Logger {
    public static PrintStream logPrintStream;

    public static void setCurrentSystemOut() {
        logPrintStream = System.out;
    }

    public static void logMessage(String message) {
        PrintStream currentOut = System.out;
        // If logPrintStream is not defined, it just prints to whatever the current System.out is
        if(logPrintStream != null) System.setOut(logPrintStream);
        System.out.println(message);
        System.setOut(currentOut);
    }

    public static String parseTestInformation(String output, Clause[] testSentence, String... errorMessages) {
        String separator = "\n--------------------------------\n";

        return "== Error Messages ==" + separator +
                String.join("\n", errorMessages) + "\n\n" +
                "== Actual Output ==" + separator +
                output + "\n" +
                "== Regex Sentence ==" + separator +
                processRegexForPrintlnOutput(combineRegex(testSentence));
    }
}
