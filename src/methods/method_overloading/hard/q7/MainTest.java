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

    final double n1 = 7.32;
    final int n2 = 3;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "56.142 31";
        return new Clause[]{
                new StringLiteral("Enter a double:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter an integer:"),
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
                Arguments.of(367.2, 56),
                Arguments.of(1982.6, 91),
                Arguments.of(1.1, 564),
                Arguments.of(1, 382194),
                Arguments.of(67.32781, 38),
                Arguments.of(467.237, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void correctMainMethodOutput(double x, int a) {
        runWithInput(x + " " + a );

        assertEquals(getAnsDouble(x), Double.parseDouble(getItemByName("a1")), 0.0000001, "Your program does not correctly print the distance between the set of doubles.");
        assertEquals(getAnsInt(a), Integer.parseInt(getItemByName("a2")), "Your program does not correctly print the distance between the set of integers.");
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

    int getAnsInt(int a){
        return Math.abs(n2 - a);
    }

    double getAnsDouble(double a){
        return Math.abs(n1 - a);
    }
}
