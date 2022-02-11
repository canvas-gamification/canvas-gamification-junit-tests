package global.tools;

import java.io.PrintStream;
import java.util.ArrayList;

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

        if (currentOut != null) {
            System.setOut(currentOut);
        }
    }
}
