package methods.method_overloading.hard.q5;

import java.util.stream.Stream;

import global.MethodTest;
import global.tools.TestOption;
import global.variables.clauses.DoubleLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
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
                new StringLiteral("The average of the three numbers is: "),
                new DoubleLiteral("threeDouble"),
                new NewLine(),
                new StringLiteral("The average of the four numbers is: "),
                new DoubleLiteral("fourDouble"),
                new NewLine(),
                new StringLiteral("The average of the five numbers is: "),
                new DoubleLiteral("fiveDouble"),
        };
    }

    public void runMain() {
        Averages.main(new String[0]);
    }

    static Stream<Arguments> threeNumbersAndTheirAverageProvider() {
        return Stream.of(
                Arguments.of(2, 1, 4, 2.333333333333333),
                Arguments.of(6, 31, 3, 13.33333333333333),
                Arguments.of(76, 122, -123, 25),
                Arguments.of(-2, -2, -1, -1.666666666666666));
    }

    static Stream<Arguments> fourNumbersAndTheirAverageProvider() {
        return Stream.of(
                Arguments.of(2, 2, 4, 4, 3),
                Arguments.of(6, 31, 3, 52, 23),
                Arguments.of(-2, -2, -1, -2, -1.75));
    }

    static Stream<Arguments> fiveNumbersAndTheirAverageProvider() {
        return Stream.of(
                Arguments.of(5, 0, 1, 2, 3, 2.2),
                Arguments.of(6, -31, 3, -52, 23, -10.2),
                Arguments.of(-2, -2, -1, -2, -3, -2));
    }

    static Stream<Arguments> mainMethodInputProvider(){
        return Stream.of(
                Arguments.of(32, 593, 213, 493, 593, 23, 12, 3492, 95, 483, 102, 4, 279.3333333333333, 280.25, 835.2),
                Arguments.of(56, 3281, 47, 47832, 4328, 17, 23, 4891, 4821, 8573, 4, 1, 1128.0, 13050.0, 3658.0),
                Arguments.of(78, 23, 1, 48, 27, 18, 43, 3718, 3, 1, 382, 3, 34.0, 34.0, 821.4)
        );
    }

    @ParameterizedTest
    @MethodSource("threeNumbersAndTheirAverageProvider")
    void threeNumbersAverageCorrect(int a, int b, int c, double avg) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, int.class},
                {c, int.class}
        };
        MethodTest m = new MethodTest(Averages.class, "average", arguments);
        Object output = m.callMethod();
        String errMsg = "Your average method does not correctly calculate the average of three integers.";
        CustomAssertions._assertEquals(avg, output, 0.000001, errMsg);
    }

    @ParameterizedTest
    @MethodSource("fourNumbersAndTheirAverageProvider")
    void fourNumbersAverageCorrect(int a, int b, int c, int d, double avg) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, int.class},
                {c, int.class},
                {d, int.class}
        };
        MethodTest m = new MethodTest(Averages.class, "average", arguments);
        Object output = m.callMethod();
        String errMsg = "Your average method does not correctly calculate the average of four integers.";
        CustomAssertions._assertEquals(avg, output, 0.000001, errMsg);
    }

    @ParameterizedTest
    @MethodSource("fiveNumbersAndTheirAverageProvider")
    void fiveNumbersAverageCorrect(int a, int b, int c, int d, int e, double avg) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, int.class},
                {c, int.class},
                {d, int.class},
                {e, int.class}
        };
        MethodTest m = new MethodTest(Averages.class, "average", arguments);
        Object output = m.callMethod();
        String errMsg = "Your average method does not correctly calculate the average of five integers.";
        CustomAssertions._assertEquals(avg, output, 0.000001, errMsg);
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void correctMainMethodOutput(int n1, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, double a1, double a2, double a3) {
        runWithInput(n1 + " " + n2 + " " + n3 + " " + n4 + " " + n5 + " " + n6 + " " + n7 + " " + n8 + " " + n9 + " " + n10 + " " + n11 + " " + n12);

        assertEquals(a1, Double.parseDouble(getItemByName("threeDouble")), 0.000001, "Your program does not print the correct average for three integers.");
        assertEquals(a2, Double.parseDouble(getItemByName("fourDouble")), 0.000001, "Your program does not print the correct average for four integers.");
        assertEquals(a3, Double.parseDouble(getItemByName("fiveDouble")), 0.000001, "Your program does not print the correct average for five integers.");
    }
}
