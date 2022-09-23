package global.utils;

import global.tools.Logger;
import global.tools.TestOption;
import global.variables.Clause;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.regex.Matcher;

import static global.tools.CustomAssertions._assertTrue;
import static global.tools.Logger.parseTestInformation;
import static global.tools.TestOption.getMethodTestSentence;
import static global.utils.RegexUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MethodUtil {
    private static ByteArrayOutputStream methodOutput;

    public static Object invokeIfMethodExists(Class<?> methodClass, String methodName, Object[] arguments, Class<?>... methodArgumentTypes) throws Throwable {
        setUpMethodOutput();
        try {
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

    public static void methodOutputFollowsCorrectStructure() {
        if (getMethodTestSentence() == null) {
            assertEquals("", getMethodOutput(), "Your method should not have any printed output.");
        } else {
            String output = getMethodOutput();
            Matcher matcher = getMatches(output, processRegexForPrintlnOutput(combineRegex(getMethodTestSentence())));
            String incorrectMethodOutputMessage = TestOption.incorrectMethodStructureErrorMessage;
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

    public static Object invokeIfMethodExists(Class<?> methodClass, String methodName) throws Throwable {
        return invokeIfMethodExists(methodClass, methodName, null, null);
    }

    private static void setUpMethodOutput() {
        methodOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(methodOutput));
    }

    public static String getMethodOutput() {
        return methodOutput.toString();
    }
}
