package methods.modular_programs.medium.q9;

import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "10 5";

        return new Clause[]{
                new StringLiteral("Enter the first number: "),
                new NewLine(),
                new StringLiteral("Enter the second number: "),
                new NewLine(),
                new PlaceHolder(),
        };
    }

    public void runMain() {
        MaxItOut.main(new String[0]);
    }

    static Stream<Arguments> inputDivisibleProvider() {
        return Stream.of(
                Arguments.of(5, 10, 10 + " is the max"),
                Arguments.of(20, 2, 20 + " is the max"),
                Arguments.of(200, -10, 200 + " is the max"),
                Arguments.of(3789123, -3789123, 3789123 + " is the max"),
                Arguments.of(5, 1, 5 + " is the max"),
                Arguments.of(1, 1, 1 + " is the max"),
                Arguments.of(5, 10, 10 + " is the max"),
                Arguments.of(2, 20, 20 + " is the max"),
                Arguments.of(200, -10, 200 + " is the max"),
                Arguments.of(10, 4, "Not divisible"),
                Arguments.of(20, -3, "Not divisible"),
                Arguments.of(-201, 10, "Not divisible"),
                Arguments.of(6, 7, "Not divisible")
        );
    }

    @ParameterizedTest
    @MethodSource("inputDivisibleProvider")
    void correctMaxOutMethod(int n1, int n2, String message) throws Throwable {
        Object[][] arguments = {
                {n1, int.class},
                {n2, int.class}
        };
        MethodTest m = new MethodTest(MaxItOut.class, "maxOut", arguments);
        Object output = m.callMethod();
        String errMsg;
        if (message.equals("Not divisible")) {
            errMsg = "Your maxOut method does not correctly identify when the numbers are not divisible.";
        } else {
            errMsg = "Your maxOut method does not return the larger number when one number is divisible by the other.";
        }
        CustomAssertions._assertEquals(message, output, errMsg);
    }

    @ParameterizedTest
    @MethodSource("inputDivisibleProvider")
    void correctMainMethodOutput(int n1, int n2, String message) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message based on the input provided.";
        runWithInput(n1 + " " + n2, new Clause[]{
                new StringLiteral(message)
        });
    }
}
