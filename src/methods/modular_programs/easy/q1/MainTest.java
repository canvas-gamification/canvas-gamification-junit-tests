package methods.modular_programs.easy.q1;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                Arguments.of(168.71, "You're above the average height in Canada!" + System.lineSeparator()),
                Arguments.of(-37, "Invalid height input!" + System.lineSeparator()),
                Arguments.of(149.23716, "You're below the average height in Canada!" + System.lineSeparator()),
                Arguments.of(-0.0001, "Invalid height input!" + System.lineSeparator()),
                Arguments.of(0, "You're below the average height in Canada!" + System.lineSeparator())
        );
    }

    static Stream<Double> userInputInputProvider() {
        return Stream.of(170.0, 168.7, -37.00, 11.00, 87.345, -13.67);
    }

    @ParameterizedTest
    @MethodSource("heightCheckerInputProvider")
    void correctHeightCheckerMethod(double height, String message) throws Throwable {
        MethodUtil.invokeIfMethodExists(AverageHeight.class, "heightChecker", new Object[]{height},
                double.class);
        String output = MethodUtil.getMethodOutput();
        assertEquals(message, output, "Your heightChecker() method does not print the correct message base on the input height.");
    }

    @ParameterizedTest
    @MethodSource("userInputInputProvider")
    void correctUserInputMethod(double input) throws Throwable {
        provideInput(String.valueOf(input));
        Object output = MethodUtil.invokeIfMethodExists(AverageHeight.class, "userInput");
        CustomAssertions._assertEquals(input, output, "Your userInput() method does not correctly get input from the user.");
    }
}
