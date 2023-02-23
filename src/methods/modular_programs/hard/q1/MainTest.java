package methods.modular_programs.hard.q1;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.*;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5";

        return new Clause[]{
                new StringLiteral("Enter a number:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        RightPrime.main(new String[]{});
    }

    static Stream<Arguments> rightPrimeInputProvider() {
        return Stream.of(
                Arguments.of(3, true),
                Arguments.of(67, false),
                Arguments.of(345, false),
                Arguments.of(37337999, true),
                Arguments.of(577489664, false),
                Arguments.of(0, false),
                Arguments.of(-1, false),
                Arguments.of(-4428, false),
                Arguments.of(-29399999, false)
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of(5, true),
                Arguments.of(0, false),
                Arguments.of(-1, false),
                Arguments.of(-23333, false),
                Arguments.of(23333, true),
                Arguments.of(233993, true),
                Arguments.of(1789576, false)
        );
    }

    @ParameterizedTest
    @MethodSource("rightPrimeInputProvider")
    public void correctRightPrimeMethod(int input, boolean isRightPrime) throws Throwable {
        Object[][] arguments = {
                {input, int.class}
        };
        MethodTest m = new MethodTest(RightPrime.class, "isRightPrime", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(isRightPrime, output,
                "Your isRightPrime method does not correctly identify if a number is a right-truncatable prime.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsCorrectOutput(int input, boolean isRightPrime) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not print the correct output for it the input number is a right-truncatable prime.";
        runWithInput(String.valueOf(input), new Clause[]{
                new StringLiteral(String.valueOf(isRightPrime))
        });
    }
}
