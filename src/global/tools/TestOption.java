package global.tools;

import global.exceptions.InvalidTestOptionException;

public class TestOption {
    public static boolean isInputTest = false;
    public static String defaultInput = null;

    public static void validate() throws InvalidTestOptionException {
        // TODO: catch these errors somewhere and make sure they are only logged to the devs and not returned to the user.
        // validate that options are valid
        if(isInputTest && defaultInput == null) {
            throw new InvalidTestOptionException("Input tests must define a TestOption.defaultInput.");
        }

        if(defaultInput != null && !isInputTest) {
            throw new InvalidTestOptionException("You have defined a defaultInput without setting TestOption.isInputTest = true.");
        }
    }
}
