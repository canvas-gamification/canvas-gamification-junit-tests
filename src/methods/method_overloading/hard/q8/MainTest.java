package methods.method_overloading.hard.q8;

import java.util.stream.Stream;

import global.MethodTest;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.variables.Clause;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The data type associated with "),
                new IntegerLiteral(14),
                new StringLiteral(" is: int"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The data type associated with "),
                new DoubleLiteral(61.34, 61.34),
                new StringLiteral(" is: double"),
                new Optional(new StringLiteral(" "))
        };
    }

    public void runMain() {
        FindDataType.main(new String[0]);
    }

    static Stream<Integer> inputIntegerProvider() {
        return Stream.of(-1000, -5, -1, 0, 1, 7, 121, 4444);
    }

    static Stream<Double> inputDoubleProvider() {
        return Stream.of(-1000.11, -5.123, -1.0, 0.7, 1.0001, 7.8989, 121.1, 4444.4444444);
    }

    @ParameterizedTest
    @MethodSource("inputIntegerProvider")
    void correctPrintTypeMethodForIntegers(int intNumber) throws Throwable {
        Object[][] arguments = {
                {intNumber, int.class}
        };
        MethodTest m = new MethodTest(FindDataType.class, "printType", arguments);
        Object output = m.callMethod();
        String errorMessage = "Your printType() method for integers does not return the correct string.";
        CustomAssertions._assertEquals("int", output, errorMessage);
    }

    @ParameterizedTest
    @MethodSource("inputDoubleProvider")
    void correctPrintTypeMethodForDoubles(double doubleNumber) throws Throwable {
        Object[][] arguments = {
                {doubleNumber, double.class}
        };
        MethodTest m = new MethodTest(FindDataType.class, "printType", arguments);
        Object output = m.callMethod();
        String errorMessage = "Your printType() method for doubles does not return the correct type.";
        CustomAssertions._assertEquals(output, "double", errorMessage);
    }
}
