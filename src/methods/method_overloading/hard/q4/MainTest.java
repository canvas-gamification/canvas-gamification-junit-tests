package methods.method_overloading.hard.q4;

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
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

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
                new StringLiteral("The area of the rectangle is: "),
                new IntegerLiteral("int_int"),
                new NewLine(),
                new StringLiteral("The area of the rectangle is: "),
                new DoubleLiteral("int_double"),
                new NewLine(),
                new StringLiteral("The area of the rectangle is: "),
                new IntegerLiteral("int_only"),
                new NewLine(),
                new StringLiteral("The area of the rectangle is: "),
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
                Arguments.of(-1, -100, 100),
                Arguments.of(1, -1, -1));
    }

    static Stream<Arguments> oneIntegerInputProvider() {
        return Stream.of(
                Arguments.of(2, 4),
                Arguments.of(5, 25),
                Arguments.of(10, 100),
                Arguments.of(-1, 1),
                Arguments.of(1000, 1000000));
    }

    static Stream<Arguments> integerDoubleInputProvider() {
        return Stream.of(
                Arguments.of(2, 2.2, 4.4),
                Arguments.of(-1, 1.12, -1.12),
                Arguments.of(-1, -1.0, 1.0),
                Arguments.of(112, 2222.123, 248877.776));
    }

    static Stream<Arguments> oneDoubleInputProvider() {
        return Stream.of(
                Arguments.of(1.2, 1.44),
                Arguments.of(-1.0, 1.0),
                Arguments.of(2.7, 7.29),
                Arguments.of(-112.1232, 12571.61197824));
    }

    @ParameterizedTest
    @MethodSource("twoIntegersInputProvider")
    void twoIntegerCorrect(int a, int b, int area) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, int.class}
        };
        MethodTest m = new MethodTest(RectangleOverload.class, "rectangleArea", arguments);
        Object output = m.callMethod();
        String errorMsg = "Your rectangleArea() method does not calculate the correct area for two integers.";
        CustomAssertions._assertEquals(area, output, errorMsg);
    }

    @ParameterizedTest
    @MethodSource("oneIntegerInputProvider")
    void oneIntegerCorrect(int a, int area) throws Throwable {
        Object[][] arguments = {
                {a, int.class}
        };
        MethodTest m = new MethodTest(RectangleOverload.class, "rectangleArea", arguments);
        Object output = m.callMethod();
        String errorMsg = "Your rectangleArea() method does not calculate the correct area for one integer.";
        CustomAssertions._assertEquals(area, output, errorMsg);
    }

    @ParameterizedTest
    @MethodSource("integerDoubleInputProvider")
    void twoDoubleCorrect(int a, double b, double area) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, double.class}
        };
        MethodTest m = new MethodTest(RectangleOverload.class, "rectangleArea", arguments);
        Object output = m.callMethod();
        String errorMsg = "Your rectangleArea() method does not calculate the correct area for an integer and a double.";
        CustomAssertions._assertEquals(area, output, 0.0001, errorMsg);
    }

    @ParameterizedTest
    @MethodSource("oneDoubleInputProvider")
    void oneDoubleCorrect(double a, double area) throws Throwable {
        Object[][] arguments = {
                {a, double.class}
        };
        MethodTest m = new MethodTest(RectangleOverload.class, "rectangleArea", arguments);
        Object output = m.callMethod();
        String errorMsg = "Your rectangleArea() method does not calculate the correct area for one double.";
        CustomAssertions._assertEquals(area, output, 0.0001, errorMsg);
    }

    @Test
    void printsCorrectMessage() {
        String errorMsg = "Your program does not print the correct message.";

        int areaIntInt = Integer.parseInt(getItemByName("int_int"));
        int areaInt = Integer.parseInt(getItemByName("int_only"));
        double areaIntegerDouble = Double.parseDouble(getItemByName("int_double"));
        double areaDouble = Double.parseDouble(getItemByName("double_only"));

        final int expectedAreaIntInt = 8;
        final int expectedAreaInt = 100;
        final double expectedAreaDoubleDouble = 10.6;
        final double expectedAreaDouble = 10.89;

        CustomAssertions._assertEquals(areaIntInt, expectedAreaIntInt, errorMsg);
        CustomAssertions._assertEquals(areaInt, expectedAreaInt, errorMsg);
        CustomAssertions._assertEquals(areaIntegerDouble, expectedAreaDoubleDouble, 0.001, errorMsg);
        CustomAssertions._assertEquals(areaDouble, expectedAreaDouble, 0.0001, errorMsg);
    }
}
