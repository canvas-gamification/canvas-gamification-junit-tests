package test;

import global.BaseRandomTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RunWithInputCustomErrorCodeTest extends BaseRandomTest {
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "something";

        return new Clause[]{
                new StringLiteral("This is a test with retrieval."),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        RunWithInputCustomErrorCode.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("apple"),
                Arguments.of("banana"),
                Arguments.of("strobbery")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Custom error message";
        runWithInput(input, new Clause[]{
                new StringLiteral(input + "+ Added string to make the test fail.", "injected")
        });
    }
}
