package methods.modular_programs.hard.q9;

import java.util.Objects;
import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        return Stream.of(0, -1, -2, -10, -100);
    }

    static Stream<Integer> inputProvider() {
        return Stream.of(1, 2, 5, 7, 10, 15, 19, 23, 34, 84);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctPrintPatternMethodForValidInput(int n) throws Throwable {
        Clause[] methodSentence = methodClauseBuilder(n);
        Object[][] arguments = {
                {n, int.class}
        };
        MethodTest m = new MethodTest(TryAngleButReflected.class, "printPattern", arguments, methodSentence);
        m.setIncorrectMethodStructureErrorMessage("Your printPattern method does not correctly print the pattern for the given input.");
        Object output = m.callMethod();
        String errMsg = "Your printPattern method should not return a value.";
        assertTrue(Objects.isNull(output), errMsg);
    }

    @ParameterizedTest
    @MethodSource("inputInvalidProvider")
    public void correctPrintPatternMethodForInvalidInput(int n) throws Throwable {
        Clause[] methodSentence = new Clause[]{
                new StringLiteral("Input number must be positive.")
        };
        Object[][] arguments = {
                {n, int.class}
        };
        MethodTest m = new MethodTest(TryAngleButReflected.class, "printPattern", arguments, methodSentence);
        m.setIncorrectMethodStructureErrorMessage("Your printPattern method does not correctly identify invalid input.");
        m.callMethod();
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctMainMethodOutput(int n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the pattern from the given input.";
        runWithInput(n + "", clauseBuilder(n));
    }

    @ParameterizedTest
    @MethodSource("inputInvalidProvider")
    public void correctInvalidMainMethodOutput(int n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print an error message for invalid input.";
        runWithInput(n + "", new Clause[]{
                new StringLiteral("Input number must be positive."),
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
