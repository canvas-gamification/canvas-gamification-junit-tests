package global;

import global.exceptions.InvalidClauseException;
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
import static global.utils.RegexUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MethodTest {
    private ByteArrayOutputStream methodOutput;
    private final Class<?> methodClass;
    private final String methodName;
    private final Object[] arguments;
    private final Class<?>[] methodArgumentTypes;
    private final Clause[] methodTestSentence;
    private String methodNotFoundErrorMessage;
    private String incorrectMethodStructureErrorMessage;

    public MethodTest(Class<?> methodClass, String methodName, Object[] arguments, Class<?>[] methodArgumentTypes) {
        this.methodClass = methodClass;
        this.methodName = methodName;
        this.arguments = arguments;
        this.methodArgumentTypes = methodArgumentTypes;
        this.methodTestSentence = null;
        this.incorrectMethodStructureErrorMessage = "Your " + methodName + " method's output did not follow the correct structure/syntax";
        setMethodOutput();
    }

    public MethodTest(Class<?> methodClass, String methodName) {
        this.methodClass = methodClass;
        this.methodName = methodName;
        this.arguments = null;
        this.methodArgumentTypes = null;
        this.methodTestSentence = null;
        this.incorrectMethodStructureErrorMessage = "Your " + methodName + " method's output did not follow the correct structure/syntax";
        setMethodOutput();
    }

    public MethodTest(Class<?> methodClass, String methodName, Object[] arguments, Class<?>[] methodArgumentTypes, Clause[] methodTestSentence) {
        this.methodClass = methodClass;
        this.methodName = methodName;
        this.arguments = arguments;
        this.methodArgumentTypes = methodArgumentTypes;
        this.methodTestSentence = methodTestSentence;
        this.incorrectMethodStructureErrorMessage = "Your " + methodName + " method's output did not follow the correct structure/syntax";
        setMethodOutput();
    }

    public MethodTest(Class<?> methodClass, String methodName, Clause[] methodTestSentence) {
        this.methodClass = methodClass;
        this.methodName = methodName;
        this.arguments = null;
        this.methodArgumentTypes = null;
        this.methodTestSentence = methodTestSentence;
        this.incorrectMethodStructureErrorMessage = "Your " + methodName + " method's output did not follow the correct structure/syntax";
        setMethodOutput();
    }

    public MethodTest(Class<?> methodClass, String methodName, Object[] arguments, Class<?>[] methodArgumentTypes, String incorrectMethodStructureErrorMessage) {
        this.methodClass = methodClass;
        this.methodName = methodName;
        this.arguments = arguments;
        this.methodArgumentTypes = methodArgumentTypes;
        this.methodTestSentence = null;
        this.incorrectMethodStructureErrorMessage = incorrectMethodStructureErrorMessage;
        setMethodOutput();
    }

    public MethodTest(Class<?> methodClass, String methodName, String incorrectMethodStructureErrorMessage) {
        this.methodClass = methodClass;
        this.methodName = methodName;
        this.arguments = null;
        this.methodArgumentTypes = null;
        this.methodTestSentence = null;
        this.incorrectMethodStructureErrorMessage = incorrectMethodStructureErrorMessage;
        setMethodOutput();
    }

    public MethodTest(Class<?> methodClass, String methodName, Object[] arguments, Class<?>[] methodArgumentTypes, Clause[] methodTestSentence, String incorrectMethodStructureErrorMessage) {
        this.methodClass = methodClass;
        this.methodName = methodName;
        this.arguments = arguments;
        this.methodArgumentTypes = methodArgumentTypes;
        this.methodTestSentence = methodTestSentence;
        this.incorrectMethodStructureErrorMessage = incorrectMethodStructureErrorMessage;
        setMethodOutput();
    }

    public MethodTest(Class<?> methodClass, String methodName, Clause[] methodTestSentence, String incorrectMethodStructureErrorMessage) {
        this.methodClass = methodClass;
        this.methodName = methodName;
        this.arguments = null;
        this.methodArgumentTypes = null;
        this.methodTestSentence = methodTestSentence;
        this.incorrectMethodStructureErrorMessage = incorrectMethodStructureErrorMessage;
        setMethodOutput();
    }

    public Object invokeIfMethodExists() throws Throwable {
        try {
            Method testMethodInvoke = methodClass.getMethod(methodName, methodArgumentTypes);
            Object output = testMethodInvoke.invoke(null, arguments);
            methodOutputFollowsCorrectStructure();
            return output;
        } catch (NoSuchMethodException | IllegalAccessException e) {
            fail(Objects.requireNonNullElseGet(
                    methodNotFoundErrorMessage,
                    () -> String.join("", methodClass.getSimpleName(), " does not contain method ", methodName, "."))
            );
            return null;
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    private void methodOutputFollowsCorrectStructure() throws InvalidClauseException {
        /*
            This method is a tweaked version of the outputFollowsCorrectStructure method in BaseTest which is used
            to check method console output using clauses. Note that random clauses and the placeHolder clause is not
            currently supported for methods.
         */

        if (methodTestSentence == null) {
            assertEquals("", getMethodOutput(), "Your " + methodName + " method should not have any printed output.");
        } else {
            // Checks that the test writer writes valid clauses does not use random clauses or placeHolder clauses
            validateMethodTestSentence();
            String output = getMethodOutput();
            Matcher matcher = getMatches(output, processRegexForPrintlnOutput(combineRegex(methodTestSentence)));
            if (incorrectMethodStructureErrorMessage.equals(""))
                incorrectMethodStructureErrorMessage = String.join("", "Your ", methodName, " method output did not follow the correct structure/syntax.");
            _assertTrue(matcher.find(), incorrectMethodStructureErrorMessage, parseTestInformation(output, methodTestSentence, incorrectMethodStructureErrorMessage));
            // Ensures that the output matches the pattern exactly
            assertEquals(output.substring(matcher.start(), matcher.end()), output, incorrectMethodStructureErrorMessage);

            // check all clauses valid
            int matchGroupNum = 1;  // match group numbers are 1-indexed
            for (Clause clause : methodTestSentence) {
                // TODO: student-facing message can include details + feedback should be dynamic to the clause's error
                _assertTrue(clause.validate(matcher.group(matchGroupNum)), incorrectMethodStructureErrorMessage, "Invalid Clause output at index " + matchGroupNum + " :" + clause.getInvalidMessage());
                matchGroupNum++;
            }
        }
    }

    private void validateMethodTestSentence() throws InvalidClauseException {
        /*
         This method makes sure that the clause structure is defined correctly, and the test writer does not use any
         features which are not allowed in methods. Parts of this method are adapted from the setRegexSentence in
         BaseTest.
         */

        //By using a set we can ensure that there are no duplicates in the regexSentence
        Set<String> namesSet = new HashSet<>();

        int i = 1;
        for (Clause clause : methodTestSentence) {
            if (clause instanceof RandomClause || clause instanceof PlaceHolder)
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
                throw new InvalidClauseException("The parameter(s) for the " + methodName + " method clause at index " + i + " are invalid. " + e.getMessage());
            }
            i += 1;
        }
    }

    public void setMethodOutput() {
        methodOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(methodOutput));
    }

    public void setIncorrectMethodStructureErrorMessage(String message) {
        this.incorrectMethodStructureErrorMessage = message;
    }

    public void setMethodNotFoundErrorMessage(String message) {
        this.methodNotFoundErrorMessage = message;
    }

    public String getMethodOutput() {
        return methodOutput.toString();
    }

    public String getMethodItemAtIndex(int index) {
        if (methodTestSentence == null)
            _fail("There is an issue with the test definition. Please contact an administrator.",
                    "Error with test definition: getMethodItemAtIndex can only be used when a methodTestSentence is declared.");
        else {
            Matcher matcher = getMatches(getMethodOutput(), processRegexForPrintlnOutput(combineRegex(methodTestSentence)));
            try {
                if (matcher.find()) return matcher.group(index);
                else fail("Your " + methodName + " method's output did not follow the correct structure/syntax.");
            } catch (IndexOutOfBoundsException e) {
                _fail("There is an issue with the test definition. Please contact an administrator.",
                        "The specified group (" + index + ") doesn't exist");
            }
        }
        return "";
    }

    public String getMethodItemByName(String name) {
        if (methodTestSentence == null)
            _fail("There is an issue with the test definition. Please contact an administrator.",
                    "Error with test definition: getMethodItemByName can only be used when a methodTestSentence is declared.");
        else {
            Clause[] regSen = methodTestSentence;
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
