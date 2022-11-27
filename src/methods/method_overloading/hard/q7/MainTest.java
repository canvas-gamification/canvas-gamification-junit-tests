package methods.method_overloading.hard.q7;

import java.util.stream.Stream;

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

public class MainTest extends BaseTest {
    public Clause[] testSentence() {
        // Java
        return new Clause[]{
                new StringLiteral("Enter a set of doubles:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter a set of integers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The distance between "),
                new DoubleLiteral("d1"),
                new StringLiteral(" and "),
                new DoubleLiteral("d2"),
                new StringLiteral(" is: "),
                new DoubleLiteral("a1"),
                new StringLiteral("The distance between "),
                new IntegerLiteral("i1"),
                new StringLiteral(" and "),
                new IntegerLiteral("i2"),
                new StringLiteral(" is: "),
                new IntegerLiteral("a2")
        };
    }

    public void runMain() {
        Distances.main(new String[0]);
    }

    static Stream<Arguments> inputDoubleProvider() {
        return Stream.of(
                Arguments.of(141.4, 591.3, 449.9),
                Arguments.of(20.0, 20.0, 0.0),
                Arguments.of(0.0, -1.0, 1.0),
                Arguments.of(-1.1, 1.0, 2.1),
                Arguments.of(-123.111, 90.11, 213.221));
    }

    static Stream<Arguments> inputIntegerProvider() {
        return Stream.of(
                Arguments.of(123, 456, 333),
                Arguments.of(0, 0, 0),
                Arguments.of(-1, 1, 2),
                Arguments.of(12, 12, 0),
                Arguments.of(46, 985, 939));
    }

    @ParameterizedTest
    @MethodSource("inputDoubleProvider")
    void testDouble(double x, double y, double distance) throws Throwable {
        String errMsg = "Your method \"calcDistance()\" does not return the correct distance for two doubles.";
        Object output = MethodUtil.invokeIfMethodExists(Distances.class, "calcDistance", new Object[]{x, y,},
                double.class, double.class);
        CustomAssertions._assertEquals(output, distance, 0.0001, errMsg);
    }

    @ParameterizedTest
    @MethodSource("inputIntegerProvider")
    void testInteger(int x, int y, int distance) throws Throwable {
        String errMsg = "Your method \"calcDistance()\" does not return the correct distance for two integers.";
        Object output = MethodUtil.invokeIfMethodExists(Distances.class, "calcDistance", new Object[]{x, y,}, int.class,
                int.class);
        CustomAssertions._assertEquals(output, distance, errMsg);
    }

    @Test
    void printsCorrectMessage() {
        String errMsg = "Your program does not print the correct message.";

        double doubleDistance = Double.parseDouble(getItemByName("doubleDistance"));
        int intDistance = Integer.parseInt(getItemByName("intDistance"));

        final double expectedDoubleDistance = 449.9;
        final int expectedIntDistance = 939;

        CustomAssertions._assertEquals(expectedDoubleDistance, doubleDistance, errMsg);
        CustomAssertions._assertEquals(expectedIntDistance, intDistance, errMsg);
    }
}