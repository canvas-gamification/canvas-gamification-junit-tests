package methods.method_overloading.hard.q2;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Hello, how are you doing?\n39";
        return new Clause[]{
                new StringLiteral("Please enter a sentence:"),
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
        return Stream.of(
                Arguments.of("Hello 0, how are you doing?", 27),
                Arguments.of("Did you ever hear the tragedy of Darth Plagueis The Wise?", 57),
                Arguments.of("Method overloading is the best!", 31),
                Arguments.of("", 0)
        );
    }

    static Stream<Arguments> inputProviderStringAndInt() {
        return Stream.of(
                Arguments.of("Hello, how are you doing?", 39, 64),
                Arguments.of("Hello there. General Kenobi, you are a bold one.", 0, 48),
                Arguments.of("Time will not slow down when something unpleasant lies ahead.", -59, 2)
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of("The Stone of Tear will never fall, till Callandor is wielded by the Dragon’s hand. The Stone of Tear will never fall, till the People of the Dragon come.", 153, 160),
                Arguments.of(System.lineSeparator(), 0, 7),
                Arguments.of("Never gonna35232 give youUp!!!Never fonna 5540994", 49, 56)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProviderString")
    void correctStringLengthMethod(String message, int stringLength) throws Throwable {
        Object[][] arguments = {
                {message, String.class}
        };
        MethodTest m = new MethodTest(Overload101.class, "stringLength", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(stringLength, output, "Your method does not correctly calculate the length of a string.");
    }

    @ParameterizedTest
    @MethodSource("inputProviderStringAndInt")
    void correctStringLengthMethodWithInteger(String message, int n, int stringLength) throws Throwable {
        Object[][] arguments = {
                {message, String.class},
                {n, int.class}
        };
        MethodTest m = new MethodTest(Overload101.class, "stringLength", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(stringLength, output, "Your method does not correctly calculate the length of a string plus an integer.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String message, int stringLength, int stringLengthPlusInt) {
        runWithInput(message);
        assertEquals(Integer.parseInt(getItemByName("length1")), stringLength, "Your program does not correctly output the length of a string.");
        assertEquals(Integer.parseInt(getItemByName("length2")), stringLengthPlusInt, "Your program does not correctly output the length of a string plus the specified integer.");
    }
}
