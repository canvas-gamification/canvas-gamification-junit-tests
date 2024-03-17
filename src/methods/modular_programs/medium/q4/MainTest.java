package methods.modular_programs.medium.q4;

import java.util.stream.Stream;

import global.MethodTest;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "100";
        return new Clause[]{
                new StringLiteral("Enter your current temperature \\( in fahrenheit \\): "),
                new NewLine(),
                new PlaceHolder(),
        };
    }

    public void runMain() {
        CharaComb.main(new String[0]);
    }

    static Stream<Double> inputAbove100Provider() {
        return Stream.of(100.0, 100.1, 200.0, 1231.123, 5555.11);
    }

    static Stream<Double> inputBelow100Provider() {
        return Stream.of(99.99999, 0.0, 0.1, 99.0, 34.12, 55.2, 3.1);
    }
    static Stream<Double> inputProvider() {
        return Stream.of(100.0, 100.1, 200.0, 1231.123, 5555.11, 99.99999, 0.0, 0.1, 99.0, 34.12, 55.2, 3.1);
    }

    @ParameterizedTest
    @MethodSource("inputAbove100Provider")
    public void correctsOutputAbove100(double temp) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message when the temperature is above 100 degrees.";
        runWithInput(temp + "", new Clause[]{
                new StringLiteral("You have a fever.")
        });
    }

    @ParameterizedTest
    @MethodSource("inputBelow100Provider")
    public void correctsOutputBelow100(double temp) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message when temperature is below 100 oF";
        runWithInput(temp + "", new Clause[]{
                new StringLiteral("You don't have a fever.")
        });
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctFeverCheckMethod(double n) throws Throwable {
        Clause[] methodSentence;
        if (n >= 100) {
            methodSentence = new Clause[]{
                    new StringLiteral("You have a fever."),
                    new Optional(new StringLiteral(" "))
            };
        } else {
            methodSentence = new Clause[]{
                    new StringLiteral("You don't have a fever."),
                    new Optional(new StringLiteral(" "))
            };
        }
        Object[][] arguments = {
                {n, double.class}
        };
        MethodTest m = new MethodTest(CharaComb.class, "feverCheck", arguments, methodSentence);
        m.callMethod();
    }
}
