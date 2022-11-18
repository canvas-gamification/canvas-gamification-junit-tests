package methods.method_overloading.hard.q5;

import java.util.stream.Stream;

import global.MethodTest;
import global.tools.TestOption;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "2 1 4 6 31 3 51 2 1 4 5 999";
        return new Clause[]{
                new StringLiteral("Enter three numbers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter four numbers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter five numbers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The average of the following numbers is: "),
                new IntegerLiteral("threeInt"),
                new NewLine(),
                new StringLiteral("The average of the following numbers is: "),
                new IntegerLiteral("fourInt"),
                new NewLine(),
                new StringLiteral("The average of the following numbers is: "),
                new IntegerLiteral("fiveInt"),
        };
    }

    public void runMain() {
        Averages.main(new String[0]);
    }

    static Stream<Arguments> threeNumbersAndTheirAverageProvider() {
        return Stream.of(
                Arguments.of(2, 1, 4, 2),
                Arguments.of(6, 31, 3, 13),
                Arguments.of(76, 122, -123, 25),
                Arguments.of(-2, -2, -1, -1));
    }

    static Stream<Arguments> fourNumbersAndTheirAverageProvider() {
        return Stream.of(
                Arguments.of(2, 2, 4, 4, 3),
                Arguments.of(6, 31, 3, 52, 23),
                Arguments.of(-2, -2, -1, -2, -1));
    }

    static Stream<Arguments> fiveNumbersAndTheirAverageProvider() {
        return Stream.of(
                Arguments.of(5, 0, 1, 2, 3, 2),
                Arguments.of(6, -31, 3, -52, 23, -10),
                Arguments.of(-2, -2, -1, -2, -3, -2));
    }

    @ParameterizedTest
    @MethodSource("threeNumbersAndTheirAverageProvider")
    void threeNumbersAverageCorrect(int a, int b, int c, int avg) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, int.class},
                {c, int.class}
        };
        MethodTest m = new MethodTest(Averages.class, "average", arguments);
        Object output = m.callMethod();
        String errMsg = "Your average method does not correctly calculate the average of three numbers";
        CustomAssertions._assertEquals(avg, output, errMsg);
    }

    @ParameterizedTest
    @MethodSource("fourNumbersAndTheirAverageProvider")
    void fourNumbersAverageCorrect(int a, int b, int c, int d, int avg) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, int.class},
                {c, int.class},
                {d, int.class}
        };
        MethodTest m = new MethodTest(Averages.class, "average", arguments);
        Object output = m.callMethod();
        String errMsg = "Your average method does not correctly calculate the average of four numbers";
        CustomAssertions._assertEquals(avg, output, errMsg);
    }

    @ParameterizedTest
    @MethodSource("fiveNumbersAndTheirAverageProvider")
    void fiveNumbersAverageCorrect(int a, int b, int c, int d, int e, int avg) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, int.class},
                {c, int.class},
                {d, int.class},
                {e, int.class}
        };
        MethodTest m = new MethodTest(Averages.class, "average", arguments);
        Object output = m.callMethod();
        String errMsg = "Your average method does not correctly calculate the average of five numbers";
        CustomAssertions._assertEquals(avg, output, errMsg);
    }

    @Test
    void printsCorrectMessage() {
        runWithInput("32 593 213 493 593 23 12 3492 95 483 102 4");

        assertEquals(279, Integer.parseInt(getItemByName("threeInt")), "Your program does not print the correct average for three numbers");
        assertEquals(280, Integer.parseInt(getItemByName("fourInt")), "Your program does not print the correct average for four numbers");
        assertEquals(835, Integer.parseInt(getItemByName("fiveInt")), "Your program does not print the correct average for five numbers");
    }
}