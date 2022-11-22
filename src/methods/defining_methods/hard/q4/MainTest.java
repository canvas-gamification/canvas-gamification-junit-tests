package methods.defining_methods.hard.q4;

import java.util.stream.Stream;

import global.MethodTest;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5 10";
        return new Clause[]{
                new StringLiteral("Enter the first number:"),
                new Optional(new StringLiteral(" ")),
                new StringLiteral("Enter the second number:"),
                new Optional(new StringLiteral(" ")),
                new StringLiteral("The greater number is "),
                new IntegerLiteral("number")
        };
    }

    public void runMain() {
        GreaterThan.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(1, 2, 2),
                Arguments.of(2, 1, 2),
                Arguments.of(-1, -2, -1),
                Arguments.of(-2, -1, -1),
                Arguments.of(-1, 0, 0),
                Arguments.of(0, -1, 0),
                Arguments.of(0, 0, 0),
                Arguments.of(-1, 1, 1),
                Arguments.of(1, -1, 1),
                Arguments.of(1000, 999, 1000),
                Arguments.of(1, -1000, 1),
                Arguments.of(50, 531830, 531830),
                Arguments.of(8537285, 12, 8537285),
                Arguments.of(5673892, 482204, 5673892),
                Arguments.of(-75342, 6849, 6849));
    }

    @ParameterizedTest
    @MethodSource("correctInputProvider")
    void correctGreaterNumMethod(int a, int b, int greater) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, int.class}
        };
        MethodTest m = new MethodTest(GreaterThan.class, "greaterNum", arguments);
        Object output = m.callMethod();
        String errorMessage = "Your greaterNum() method does not return the larger number.";
        CustomAssertions._assertEquals(greater, output, errorMessage);
    }

    @ParameterizedTest
    @MethodSource("correctInputProvider")
    void printsCorrectNumber(int a, int b, int greater) {
        runWithInput(a + " " + b);
        assertEquals(greater, Integer.parseInt(getItemByName("number")), "Your program does not print the larger number.");
    }
}
