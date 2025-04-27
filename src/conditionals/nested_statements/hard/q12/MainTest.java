package conditionals.nested_statements.hard.q12;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
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
        TestOption.defaultInput = "87";
        return new Clause[]{
                new StringLiteral("Enter score: "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        ScoreAnalyzer.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("100", "Group 2 - A"),
                Arguments.of("99", "Group 1 - A"),
                Arguments.of("88", "Group 2 - B"),
                Arguments.of("85", "Group 1 - B"),
                Arguments.of("70", "Group 2 - C"),
                Arguments.of("73", "Group 1 - C"),
                Arguments.of("66", "Group 2 - D"),
                Arguments.of("61", "Group 1 - D"),
                Arguments.of("59", "Group 1 - F"),
                Arguments.of("50", "Group 2 - F")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testScoreCategory(String grade, String expectedOutput) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly output the group and grade.";
        runWithInput(grade, new Clause[]{
                new StringLiteral(expectedOutput)
        });
    }
}

