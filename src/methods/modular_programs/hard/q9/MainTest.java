package methods.modular_programs.hard.q9;

import java.util.Objects;
import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
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
        TestOption.defaultInput = "5";
        return new Clause[]{
                new StringLiteral("Enter number of lines\\: "),
                new NewLine(),
                new PlaceHolder(),
        };
    }

    public void runMain() {
        TryAngleButReflected.main(new String[0]);
    }

    static Stream<Integer> inputInvalidProvider() {
        return Stream.of(-1, -2, -10, -100);
    }

    @RepeatedTest(50)
    public void methodReturnsCorrectPattern(RepetitionInfo repetitionInfo) throws Throwable {
        int n = repetitionInfo.getCurrentRepetition();
        Clause[] methodSentence = methodClauseBuilder(n);
        Object[][] arguments = {
                {n, int.class}
        };
        MethodTest m = new MethodTest(TryAngleButReflected.class, "printPattern", arguments, methodSentence);
        m.setIncorrectMethodStructureErrorMessage("Your printPattern() method does not print the correct pattern for the given input.");
        Object output = m.callMethod();
        String errMsg = "Your printPattern() method should not return a value.";

        CustomAssertions._assertTrue(Objects.isNull(output), errMsg, errMsg);
    }

    @ParameterizedTest
    @MethodSource("inputInvalidProvider")
    public void methodPrintsErrorForInvalidInput(int n) throws Throwable {
        Clause[] methodSentence = new Clause[]{
                new StringLiteral("Number must be positive")
        };
        Object[][] arguments = {
                {n, int.class}
        };
        MethodTest m = new MethodTest(TryAngleButReflected.class, "printPattern", arguments, methodSentence);
        m.setIncorrectMethodStructureErrorMessage("Your printPattern() method does not print an error message for the given input.");
        Object output = m.callMethod();
        String errMsg = "Your printPattern() method returns a value, which is not allowed.";

        CustomAssertions._assertTrue(Objects.isNull(output), errMsg, errMsg);
    }


    @RepeatedTest(50)
    public void printsCorrectPatternValidInput(RepetitionInfo repetitionInfo) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct pattern for the given input.";

        int n = repetitionInfo.getCurrentRepetition();

        runWithInput(n + "", clauseBuilder(n));
    }

    @ParameterizedTest
    @MethodSource("inputInvalidProvider")
    public void printsErrorForInvalidInput(int n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print an error message for the given input.";
        runWithInput(n + "", new Clause[]{
                new StringLiteral("Number must be positive"),
        });
    }

    private static Clause[][] clauseBuilder(int n) {
        Clause[][] clauses = new Clause[1][n * 2];
        int count = 0;
        for (int i = n; i > 0; i--) {
            String s = "";
            for (int j = 1; j <= i; j++) {
                s += j + " ";
            }
            clauses[0][count++] = new StringLiteral(s);
            clauses[0][count++] = new NewLine();
        }
        return clauses;
    }

    private static Clause[] methodClauseBuilder(int n) {
        Clause[] clauses = new Clause[n * 2];
        int count = 0;
        for (int i = n; i > 0; i--) {
            String s = "";
            for (int j = 1; j <= i; j++) {
                s += j + " ";
            }
            clauses[count++] = new StringLiteral(s);
            clauses[count++] = new NewLine();
        }
        return clauses;
    }
}
