package methods.modular_programs.easy.q1;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "170.0";
        return new Clause[]{
                new StringLiteral("Please enter your height in cm: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        AverageHeight.main(new String[0]);
    }

    static Stream<Arguments> heightCheckerInputProvider() {
        return Stream.of(
                Arguments.of(170.0, "You're above the average height in Canada!" + System.lineSeparator()),
                Arguments.of(168.7, "You're below the average height in Canada!" + System.lineSeparator()),
                Arguments.of(168.70001, "You're above the average height in Canada!" + System.lineSeparator()),
                Arguments.of(-37, "Invalid input!" + System.lineSeparator()),
                Arguments.of(149.23716, "You're below the average height in Canada!" + System.lineSeparator()),
                Arguments.of(-0.0001, "Invalid input!" + System.lineSeparator()),
                Arguments.of(0, "You're below the average height in Canada!" + System.lineSeparator())
        );
    }

    static Stream<Double> userInputInputProvider() {
        return Stream.of(
                170.0,
                168.7,
                -37.00,
                11.00,
                87.345,
                -13.67
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        Random r = new Random();
        return Stream.of(
                Arguments.of(-0.001, "Invalid input!"),
                Arguments.of(r.nextDouble() * 168.7, "You're below the average height in Canada!"),
                Arguments.of(r.nextDouble() * 50 + 169, "You're above the average height in Canada!")
        );
    }

    @ParameterizedTest
    @MethodSource("heightCheckerInputProvider")
    void correctHeightCheckerMethod(double height, String message) throws Throwable {
        Object[][] arguments = {
                {height, double.class}
        };
        Clause[] methodTestSentence = {
                new StringLiteral(message)
        };
        String incorrectMethodStructureErrorMessage =
                "Your heightChecker method does not print the correct message based on the input height.";
        MethodTest methodTest = new MethodTest(AverageHeight.class, "heightChecker", arguments,
                methodTestSentence, incorrectMethodStructureErrorMessage);
        methodTest.callMethod();
    }

    @ParameterizedTest
    @MethodSource("userInputInputProvider")
    void correctUserInputMethod(double input) throws Throwable {
        provideInput(String.valueOf(input));
        Clause[] methodSentence = new Clause[]{
                new StringLiteral("Please enter your height in cm: "),
                new NewLine()
        };
        MethodTest m = new MethodTest(AverageHeight.class, "userInput", methodSentence);
        m.setIncorrectMethodStructureErrorMessage("Your userInput method does not print the correct console output.");
        Object output = m.callMethod();
        CustomAssertions._assertEquals(input, output,
                "Your userInput method does not correctly get input from the user.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(double height, String message) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not print the correct message based on the input height.";
        runWithInput(String.valueOf(height), new Clause[]{
                new StringLiteral(message)
        });
    }
}
