package methods.method_overloading.hard.q2;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest extends BaseTest {
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Hello, how are you doing?\n39";
        return new Clause[]{
                new StringLiteral("Please enter a sentence:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Please enter an integer:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The length of the string is: "),
                new IntegerLiteral("length1"),
                new NewLine(),
                new StringLiteral("The length of the string plus the integer is: "),
                new IntegerLiteral("length2")
        };
    }

    public void runMain() {
        Overload101.main(new String[0]);
    }

    static Stream<Arguments> inputProviderString() {
        return Stream.of(Arguments.of("Hello 0, how are you doing?", 39, 27),
                Arguments.of("Did you ever hear the tragedy of Darth Plagueis The Wise?", 0, 57),
                Arguments.of("Method overloading is the best!", -11, 31));
    }

    static Stream<Arguments> inputProviderStringAndInt(){
        return Stream.of(Arguments.of("Hello, how are you doing?", 39, 64),
                Arguments.of("Hello there. General Kenobi, you are a bold one.", 0, 48),
                Arguments.of("Time will not slow down when something unpleasant lies ahead.", -59, 2));
    }

    @ParameterizedTest
    @MethodSource("inputProviderString")
    void methodCalculatesLengthOfStringCorrectly(String message, int n, int stringLength) {
        runWithInput(String.join(System.lineSeparator(), message, String.valueOf(n)));
        String failMessage = "Your program does not have a method for calculating the length of a string.";
        int result = (int) invokeIfMethodExists(Overload101.class, "stringLength", failMessage, new Object[]{message}, String.class);
        assertEquals(result, stringLength, "Your method does not correctly calculate the length of a string.");
        assertEquals(Integer.parseInt(getItemByName("length1")), stringLength, "Your program does not correctly output the length of a string.");
    }

    @ParameterizedTest
    @MethodSource("inputProviderStringAndInt")
    void methodCalculatesLengthOfStringCorrectlyAndInt(String message, int n, int stringLength) {
        runWithInput(String.join(System.lineSeparator(), message, String.valueOf(n)));
        String failMessage = "Your program does not have a method for calculating the length of a string plus an integer.";
        int result = (int) invokeIfMethodExists(Overload101.class, "stringLength", failMessage, new Object[]{message, n}, String.class, int.class);
        assertEquals(result, stringLength, "Your method does not correctly calculate the length of a string plus an integer.");
        assertEquals(Integer.parseInt(getItemByName("length2")), stringLength, "Your program does not correctly output the length of a string plus an integer.");
    }

    public static Object invokeIfMethodExists(Class<?> methodClass, String methodName, String failMessage, Object[] arguments, Class<?> ... methodArgumentTypes) {
        try {
            Method m = methodClass.getMethod(methodName, methodArgumentTypes);
            return m.invoke(null, arguments);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            fail(failMessage);
            return null;
        }
    }

}
