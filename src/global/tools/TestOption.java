package global.tools;

import global.exceptions.InvalidTestOptionException;

public class TestOption {
    public static boolean runMainBeforeEach = false;

    public static void validate() throws InvalidTestOptionException {
        // validate that options are valid
//        throw new InvalidTestOptionException("This is a test.");  // for example
    }

    public static boolean shouldRunMainBeforeEach() {
        return runMainBeforeEach;
    }
}
