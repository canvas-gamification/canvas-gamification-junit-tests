package conditionals.nested_statements.hard.q12;

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

    @Override
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "87";
        return new Clause[]{
                new StringLiteral("Enter score: "),
                new PlaceHolder(),
                new NewLine(),
                new PlaceHolder()
        };
    }

    @Override
    public void runMain() {
        ScoreAnalyzer.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("98", "Even Score", "Excellent"),
                Arguments.of("95", "Odd Score", "Amazing"),
                Arguments.of("83", "Odd Score", "Pretty Good"),
                Arguments.of("80", "Even Score", "Good"),
                Arguments.of("77", "Odd Score", "Okay"),
                Arguments.of("72", "Even Score", "Fair"),
                Arguments.of("61", "Odd Score", "Almost there"),
                Arguments.of("66", "Even Score", "Needs Improvement"),
                Arguments.of("59", "Odd Score", "Try again next time"),
                Arguments.of("50", "Even Score", "Fail")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testScoreCategory(String input, String expectedLine1, String expectedLine2) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly determine the score category.";
        runWithInput(input, new Clause[]{
                new StringLiteral(expectedLine1),
                new StringLiteral(expectedLine2)
        });
    }
}
