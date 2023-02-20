package methods.method_overloading.hard.q4;

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
        TestOption.defaultInput = "2 4\n5.3 3.3";
        return new Clause[]{
                new StringLiteral("Enter two integers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter two doubles:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The area of the first rectangle is: "),
                new IntegerLiteral("int_int"),
                new NewLine(),
                new StringLiteral("The area of the second rectangle is: "),
                new DoubleLiteral("int_double"),
                new NewLine(),
                new StringLiteral("The area of the third rectangle is: "),
                new IntegerLiteral("int_only"),
                new NewLine(),
                new StringLiteral("The area of the fourth rectangle is: "),
                new DoubleLiteral("double_only"),
        };
    }

    public void runMain() {
        RectangleOverload.main(new String[0]);
    }

    static Stream<Arguments> twoIntegersInputProvider() {
        return Stream.of(
                Arguments.of(2, 4, 8),
                Arguments.of(2, 5, 10),
                Arguments.of(10, 100, 1000),
                Arguments.of(1, 1, 1));
    }

    static Stream<Arguments> oneIntegerInputProvider() {
        return Stream.of(
                Arguments.of(2, 4),
                Arguments.of(5, 25),
                Arguments.of(10, 100),
                Arguments.of(1, 1),
                Arguments.of(1000, 1000000));
    }

    static Stream<Arguments> integerDoubleInputProvider() {
        return Stream.of(
                Arguments.of(2, 2.2, 4.4),
                Arguments.of(1, 1.12, 1.12),
                Arguments.of(1, 1.0, 1.0),
                Arguments.of(112, 2222.123, 248877.776));
    }

    static Stream<Arguments> oneDoubleInputProvider() {
        return Stream.of(
                Arguments.of(1.2, 1.44),
                Arguments.of(1.0, 1.0),
                Arguments.of(2.7, 7.29),
                Arguments.of(112.1232, 12571.61197824));
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of(4, 76, 23.4246, 648372.1, 304, 93.6984, 5776, 4.2038638005841E11),
                Arguments.of(32917, 4, 57.3, 1.321, 131668, 1886144.1, 16, 1.745041),
                Arguments.of(43, 23, 43, 763, 989, 1849.0, 529, 582169.0),
                Arguments.of(4738, 32, 4372.432, 584.432391, 151616, 2.0716582816E7, 1024, 341561.21964997693)
        );
    }

    @ParameterizedTest
    @MethodSource("twoIntegersInputProvider")
    void correctTwoIntegersRectangleAreaMethod(int a, int b, int area) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, int.class}
        };
        MethodTest m = new MethodTest(RectangleOverload.class, "rectangleArea", arguments);
        Object output = m.callMethod();
        String errorMsg = "Your rectangleArea method does not calculate the correct area using two integers.";
        CustomAssertions._assertEquals(area, output, errorMsg);
    }

    @ParameterizedTest
    @MethodSource("oneIntegerInputProvider")
    void correctOneIntegerRectangleAreaMethod(int a, int area) throws Throwable {
        Object[][] arguments = {
                {a, int.class}
        };
        MethodTest m = new MethodTest(RectangleOverload.class, "rectangleArea", arguments);
        Object output = m.callMethod();
        String errorMsg = "Your rectangleArea method does not calculate the correct area using one integer.";
        CustomAssertions._assertEquals(area, output, errorMsg);
    }

    @ParameterizedTest
    @MethodSource("integerDoubleInputProvider")
    void correctTwoDoublesRectangleAreaMethod(int a, double b, double area) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, double.class}
        };
        MethodTest m = new MethodTest(RectangleOverload.class, "rectangleArea", arguments);
        Object output = m.callMethod();
        String errorMsg = "Your rectangleArea method does not calculate the correct area using an integer and a double.";
        CustomAssertions._assertEquals(area, output, 0.0001, errorMsg);
    }

    @ParameterizedTest
    @MethodSource("oneDoubleInputProvider")
    void correctOneDoubleRectangleAreaMethod(double a, double area) throws Throwable {
        Object[][] arguments = {
                {a, double.class}
        };
        MethodTest m = new MethodTest(RectangleOverload.class, "rectangleArea", arguments);
        Object output = m.callMethod();
        String errorMsg = "Your rectangleArea method does not calculate the correct area using one double.";
        CustomAssertions._assertEquals(area, output, 0.0001, errorMsg);
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void correctMainMethodOutput(int a, int b, double x, double y, int twoInts, double intDouble, int oneInt, double oneDouble) {
        runWithInput(a + " " + b + " " + x + " " + y);

        assertEquals(twoInts, Integer.parseInt(getItemByName("int_int")), "Your program does not print the correct output for the area of the first rectangle.");
        assertEquals(intDouble, Double.parseDouble(getItemByName("int_double")), 0.0001, "Your program does not print the correct output for the area of the second rectangle.");
        assertEquals(oneInt, Integer.parseInt(getItemByName("int_only")), "Your program does not print the correct output for the area of the third rectangle.");
        assertEquals(oneDouble, Double.parseDouble(getItemByName("double_only")), 0.0001, "Your program does not print the correct output for the area of the fourth rectangle.");
    }
}
