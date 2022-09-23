package global.utils;

import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.RandomClause;
import global.variables.clauses.PlaceHolder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;

import static global.tools.CustomAssertions._assertTrue;
import static global.tools.CustomAssertions._fail;
import static global.tools.Logger.parseTestInformation;
import static global.tools.TestOption.getMethodTestSentence;
import static global.utils.RegexUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MethodUtil {
    private static ByteArrayOutputStream methodOutput;
    private static String nameOfMethod;

    public static Object invokeIfMethodExists(Class<?> methodClass, String methodName, Object[] arguments, Class<?>... methodArgumentTypes) throws Throwable {
        // Resets class variables
        methodSetUp();
        try {
            nameOfMethod = methodName;
            Method testMethodInvoke = methodClass.getMethod(methodName, methodArgumentTypes);
            Object output = testMethodInvoke.invoke(null, arguments);
            methodOutputFollowsCorrectStructure();
            return output;
        } catch (NoSuchMethodException | IllegalAccessException e) {
            fail(Objects.requireNonNullElseGet(
                    TestOption.invalidMethodMessage,
                    () -> String.join("", methodClass.getSimpleName(), " does not contain method ", methodName, "."))
            );
            return null;
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    private static void methodOutputFollowsCorrectStructure() throws InvalidClauseException {
        /*
            This method is a tweaked version of the outputFollowsCorrectStructure method in BaseTest which is used
            to check method console output using clauses. Note that random clauses and the placeHolder clause is not
            currently supported for methods.
         */

        if (getMethodTestSentence() == null) {
            assertEquals("", getMethodOutput(), "Your " + nameOfMethod + " method should not have any printed output.");
        } else {
            // Checks that the test writer writes valid clauses does not use random clauses or placeHolder clauses
            validateMethodTestSentence();
            String output = getMethodOutput();
            Matcher matcher = getMatches(output, processRegexForPrintlnOutput(combineRegex(getMethodTestSentence())));
            String incorrectMethodOutputMessage = TestOption.incorrectMethodStructureErrorMessage;
            if(incorrectMethodOutputMessage.equals(""))
                incorrectMethodOutputMessage = String.join("", "Your ", nameOfMethod, " method output did not follow the correct structure/syntax.");
            _assertTrue(matcher.find(), incorrectMethodOutputMessage, parseTestInformation(output, getMethodTestSentence(), incorrectMethodOutputMessage));
            // Ensures that the output matches the pattern exactly
            assertEquals(output.substring(matcher.start(), matcher.end()), output, incorrectMethodOutputMessage);

            // check all clauses valid
            int matchGroupNum = 1;  // match group numbers are 1-indexed
            for (Clause clause : getMethodTestSentence()) {
                // TODO: student-facing message can include details + feedback should be dynamic to the clause's error
                _assertTrue(clause.validate(matcher.group(matchGroupNum)), incorrectMethodOutputMessage, "Invalid Clause output at index " + matchGroupNum + " :" + clause.getInvalidMessage());
                matchGroupNum++;
            }
        }
    }

    private static void validateMethodTestSentence() throws InvalidClauseException {
        /*
         This method makes sure that the clause structure is defined correctly, and the test writer does not use any
         features which are not allowed in methods. Parts of this method are adapted from the setRegexSentence in
         BaseTest.
         */

        //By using a set we can ensure that there are no duplicates in the regexSentence
        Set<String> namesSet = new HashSet<>();

        int i = 1;
        for (Clause clause : getMethodTestSentence()){
            if(clause instanceof RandomClause || clause instanceof PlaceHolder)
                _fail("There is an issue with the test definition. Please contact an administrator.",
                        "Error with test definition: The method clause system does not support random clauses or the placeHolder clause.");
            if (clause.getName() != null) {
                if (namesSet.contains(clause.getName())) {
                    _fail("There is an issue with the test definition. Please contact an administrator.",
                            "The name " + clause.getName() + " is already in use. Make sure all names are unique");
                }
                namesSet.add(clause.getName());
            }
            try {
                clause.validateParams();
            } catch (InvalidClauseException e) {
                throw new InvalidClauseException("The parameter(s) for the " + nameOfMethod + " method clause at index " + i + " are invalid. " + e.getMessage());
            }
            i += 1;
        }
    }

    public static Object invokeIfMethodExists(Class<?> methodClass, String methodName) throws Throwable {
        return invokeIfMethodExists(methodClass, methodName, null, null);
    }

    private static void methodSetUp() {
        methodOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(methodOutput));
        nameOfMethod = "";
    }

    public static String getMethodOutput() {
        return methodOutput.toString();
    }

    public static String getMethodItemAtIndex(int index) {
        if(TestOption.methodTestSentence == null)
            _fail("There is an issue with the test definition. Please contact an administrator.",
                    "Error with test definition: getMethodItemAtIndex can only be used when a methodTestSentence is declared.");
        else {
            Matcher matcher = getMatches(getMethodOutput(), processRegexForPrintlnOutput(combineRegex(getMethodTestSentence())));
            try {
                if (matcher.find()) return matcher.group(index);
                else fail("Your " + nameOfMethod + " method output did not follow the correct structure/syntax.");
            } catch (IndexOutOfBoundsException e) {
                _fail("There is an issue with the test definition. Please contact an administrator.",
                        "The specified group (" + index + ") doesn't exist");
            }
        }
        return "";
    }

    public static String getMethodItemByName(String name) {
        if(TestOption.methodTestSentence == null)
            _fail("There is an issue with the test definition. Please contact an administrator.",
                    "Error with test definition: getMethodItemByName can only be used when a methodTestSentence is declared.");
        else {
            Clause[] regSen = getMethodTestSentence();
            for (int i = 0; i < regSen.length; i++) {
                if (regSen[i].getName() != null && regSen[i].getName().equals(name))
                    return getMethodItemAtIndex(i + 1);
            }
            _fail("There is an issue with the test definition. Please contact an administrator.",
                    "The specified group ('" + name + "') doesn't exist");
        }
        return "";
    }
}
