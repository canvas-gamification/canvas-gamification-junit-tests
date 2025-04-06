package conditionals.simple_programs_with_decision_points.medium.q10;

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

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "25";
        return new Clause[]{
                new StringLiteral("What is your age?"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        VirtualBouncer.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(25, "Congrats, you can vote!."),
        Arguments.of(15, "You are not allowed to vote yet"),
        Arguments.of(19, "Congrats, you can vote!.")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String ageInput, String expectedOutput) throws InvalidClauseException {
        runWithInput(ageInput + System.lineSeparator(), new Clause[]{
                new StringLiteral(expectedOutput)
        });
    }

}

