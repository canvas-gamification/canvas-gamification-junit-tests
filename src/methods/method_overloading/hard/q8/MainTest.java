package methods.method_overloading.hard.q8;

import java.util.stream.Stream;

import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.clauses.PlaceHolder;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "39 27.45";
        return new Clause[]{
                new StringLiteral("Enter an integer\\:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter a double\\:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
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

    static Stream<Arguments> mainMethodInput() {
        return Stream.of(
                Arguments.of(5, 3.54),
                Arguments.of(-67, -438462.56),
                Arguments.of(789317, -23.4316),
                Arguments.of(-4, 45.21)
        );
    }

    @ParameterizedTest
    @MethodSource("inputIntegerProvider")
    void correctPrintTypeIntegerMethod(int intNumber) throws Throwable {
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
    void correctPrintTypeDoubleMethod(double doubleNumber) throws Throwable {
        Object[][] arguments = {
                {doubleNumber, double.class}
        };
        MethodTest m = new MethodTest(FindDataType.class, "printType", arguments);
        Object output = m.callMethod();
        String errorMessage = "Your printType() method for doubles does not return the correct type.";
        CustomAssertions._assertEquals(output, "double", errorMessage);
    }

    @ParameterizedTest
    @MethodSource("mainMethodInput")
    void printsCorrectOutput(int x, double y) throws InvalidClauseException {
        runWithInput(x + " " + y, new Clause[][]{
                {
                        new StringLiteral("The data type associated with " + x + " is: "),
                        new StringLiteral("int"),
                        new NewLine(),
                        new StringLiteral("The data type associated with " + y + " is: "),
                        new StringLiteral("double")
                }
        });
    }
}
