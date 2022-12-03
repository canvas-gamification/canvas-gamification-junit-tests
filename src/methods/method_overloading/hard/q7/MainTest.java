package methods.method_overloading.hard.q7;

import java.util.stream.Stream;

import global.MethodTest;
import global.tools.TestOption;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "22.2 56.142 6 31";
        return new Clause[]{
                new StringLiteral("Enter a set of doubles:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter a set of integers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The distance between the set of doubles is: "),
                new DoubleLiteral("a1"),
                new NewLine(),
                new StringLiteral("The distance between the set of integers is: "),
                new IntegerLiteral("a2")
        };
    }

    public void runMain() {
        Distances.main(new String[0]);
    }

    static Stream<Arguments> doubleInputProvider() {
        return Stream.of(
                Arguments.of(141.4, 591.3, 449.9),
                Arguments.of(20.0, 20.0, 0.0),
                Arguments.of(0.0, -1.0, 1.0),
                Arguments.of(-1.1, 1.0, 2.1),
                Arguments.of(-123.111, 90.11, 213.221));
    }

    static Stream<Arguments> integerInputProvider() {
        return Stream.of(
                Arguments.of(123, 456, 333),
                Arguments.of(0, 0, 0),
                Arguments.of(-1, 1, 2),
                Arguments.of(12, 12, 0),
                Arguments.of(46, 985, 939));
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of(367.2, 1982.6, 56, 91, 1615.4, 35),
                Arguments.of(1.1, 1, 564, 382194, 0.1, 381630),
                Arguments.of(67.32781, 467.237, 38, 2, 399.90919, 36)
        );
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void correctMainMethodOutput(double x, double y, int a, int b, double ans1, int ans2) {
        runWithInput(x + " " + y + " " + a + " " + b);

        assertEquals(ans1, Double.parseDouble(getItemByName("a1")), 0.0000001, "Your program does not correctly print the distance between the set of doubles.");
        assertEquals(ans2, Integer.parseInt(getItemByName("a2")), "Your program does not correctly print the distance between the set of integers.");
    }

    @ParameterizedTest
    @MethodSource("doubleInputProvider")
    void correctCalcDistanceMethod(double x, double y, double distance) throws Throwable {
        Object[][] arguments = {
                {x, double.class},
                {y, double.class}
        };
        MethodTest m = new MethodTest(Distances.class, "calcDistance", arguments);
        Object output = m.callMethod();
        String errMsg = "Your calcDistance method does not correctly calculate the distance between two doubles.";
        CustomAssertions._assertEquals(distance, output, 0.0000001, errMsg);
    }

    @ParameterizedTest
    @MethodSource("integerInputProvider")
    void correctCalcDistanceMethod(int x, int y, int distance) throws Throwable {
        Object[][] arguments = {
                {x, int.class},
                {y, int.class}
        };
        MethodTest m = new MethodTest(Distances.class, "calcDistance", arguments);
        Object output = m.callMethod();
        String errMsg = "Your calcDistance method does not correctly calculate the distance between two integers.";
        CustomAssertions._assertEquals(distance, output, errMsg);
    }
}
