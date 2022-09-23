package global.tools;

import global.exceptions.InvalidTestOptionException;
import global.variables.Clause;

public class TestOption {
    public static boolean isInputTest = false;
    public static String defaultInput = null;
    public static String incorrectStructureErrorMessage = null;
    public static String invalidMethodMessage = null;
    public static Clause[] methodTestSentence = null;
    public static String incorrectMethodStructureErrorMessage = null;

    public static Clause[] getMethodTestSentence(){
        return methodTestSentence;
    }

    public static void validate() throws InvalidTestOptionException {
        // TODO: catch these errors somewhere and make sure they are only logged to the devs and not returned to the user.
        // validate that options are valid
        if (isInputTest && defaultInput == null) {
            throw new InvalidTestOptionException("Input tests must define a TestOption.defaultInput.");
        }

        if (defaultInput != null && !isInputTest) {
            throw new InvalidTestOptionException("You have defined a defaultInput without setting TestOption.isInputTest = true.");
        }
    }

    public static void reset() {
        // This method resets all TestOptions which are test specific and could change every test
        TestOption.incorrectStructureErrorMessage = "Your code's output did not follow the correct structure/syntax.";
        TestOption.incorrectMethodStructureErrorMessage = "";
        TestOption.invalidMethodMessage = null;
        TestOption.methodTestSentence = null;
    }
}
