package conditionals.simple_programs_with_decision_points.medium.q3;
import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.opentest4j.AssertionFailedError;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest extends BaseTest {
    // Parsons

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "19";
        return new Clause[]{
                new StringLiteral("What is your age\\? "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        VirtualBouncer.main(new String[0]);
    }

    static Stream<Integer> inputProviderUnderAge() {
        return Stream.of(1, 4, 5, 7, 8, 9, 18, 17, 10, 15);
    }

    static Stream<Integer> inputProviderOfAge() {
        return Stream.of(19, 20, 21, 25, 56, 98, 67, 45);
    }

    @ParameterizedTest
    @MethodSource("inputProviderUnderAge")
    void worksWithNumbersUnderAge(int input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program did not correctly identify an under age individual.";
        runWithInput(input + "", new Clause[]{
                new StringLiteral("Whoa there kiddo, it's past your bedtime.", "underAge")
        });
    }

    @ParameterizedTest
    @MethodSource("inputProviderOfAge")
    void worksWithNumberOfAge(int input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program did not correctly identify an individual of legal age.";
        runWithInput(input + "", new Clause[]{
                new StringLiteral("Step right in sir.", "underAge")
        });
    }

}
