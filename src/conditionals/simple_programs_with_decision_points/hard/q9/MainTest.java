package conditionals.simple_programs_with_decision_points.hard.q9;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "76";

        return new Clause[]{
                new StringLiteral("Enter the numerical grade:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        GradeToLetter.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("95", "A"),
                Arguments.of("90", "A"),
                Arguments.of("89", "B"),
                Arguments.of("80", "B"),
                Arguments.of("79", "C"),
                Arguments.of("70", "C"),
                Arguments.of("69", "D"),
                Arguments.of("60", "D"),
                Arguments.of("59", "F"),
                Arguments.of("30", "F"),
                Arguments.of("100", "A")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsCorrectLetter(String inputGrade, String expectedOutput) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct letter for the entered grade.";
        runWithInput(inputGrade, new Clause[]{
                new StringLiteral(expectedOutput)
        });
    }
}

