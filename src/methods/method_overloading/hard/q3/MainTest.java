package methods.method_overloading.hard.q3;

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
import global.utils.MethodUtil;
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
        TestOption.defaultInput = "3 9\n45.3 21.1";
        return new Clause[]{
                new StringLiteral("Enter two integers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter two doubles:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The sum of the 2 numbers: "),
                new IntegerLiteral("sumInt"),
                new NewLine(),
                new StringLiteral("The sum of the 2 numbers: "),
                new DoubleLiteral("sumDouble"),
                new NewLine()
        };
    }

    public void runMain() {
        SumOverloaded.main(new String[0]);
    }

    static Stream<Arguments> integerInputProvider() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(0, 0, 0),
                Arguments.of(1, 0, 1),
                Arguments.of(1, -1, 0),
                Arguments.of(-99, 201, 102));
    }

    static Stream<Arguments> doubleInputProvider() {
        return Stream.of(
                Arguments.of(1.1, 2.5, 3.6),
                Arguments.of(0.01, 0.01, 0.02),
                Arguments.of(-1.0, 1.03, 0.03),
                Arguments.of(1.5, -1.5, 0.0),
                Arguments.of(-99.0, 201.0, 102.0),
                Arguments.of(-99.0, 201.142, 102.142),
                Arguments.of(3, 1, 4.0)
        );
    }

    static Stream<Arguments> mainMethodInputProvider(){
        return Stream.of(
                Arguments.of(2, 3, 5, 2.4, 76.2, 78.6),
                Arguments.of(-45, 6, -39, 17.2473, 16837.2, 16854.4473),
                Arguments.of(-19, -4827164, -4827183, 42.21, -7.2, 35.01),
                Arguments.of(4783, 394, 5177, 1234.123, 4893, 6127.123)
        );
    }

    @ParameterizedTest
    @MethodSource("integerInputProvider")
    public void methodIntegerCorrect(int a, int b, int sum) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, int.class}
        };
        MethodTest m = new MethodTest(SumOverloaded.class, "sum", arguments);
        Object output = m.callMethod();
        String errorMsg = "Your method did not calculate the correct sum for 2 integers.";
        CustomAssertions._assertEquals(sum, output, errorMsg);
    }

    @ParameterizedTest
    @MethodSource("doubleInputProvider")
    public void methodDoubleCorrect(double a, double b, double sum) throws Throwable {
        Object[][] arguments = {
                {a, double.class},
                {b, double.class}
        };
        MethodTest m = new MethodTest(SumOverloaded.class, "sum", arguments);
        Object output = m.callMethod();
        String errorMsg = "Your method did not calculate the correct sum for 2 doubles.";
        CustomAssertions._assertEquals(sum, output, 0.0001, errorMsg);
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    public void printsCorrectMessage(int a, int b, int c, double x, double y, double w) {
        runWithInput(a + " " + b + " " + x + " " + y);
        assertEquals(c, Integer.parseInt(getItemByName("sumInt")), "Your program does not print the correct message for sum of 2 integers.");
        assertEquals(w, Double.parseDouble(getItemByName("sumDouble")), 0.0001,  "Your program does not print the correct message for sum of 2 doubles.");
    }
}
