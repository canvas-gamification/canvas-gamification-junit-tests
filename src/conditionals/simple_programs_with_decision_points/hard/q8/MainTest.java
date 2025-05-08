package conditionals.simple_programs_with_decision_points.hard.q8;

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
//Parsons
    static final int THRESHOLD = 50;

    @Override
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1\n2";

        return new Clause[]{
            new StringLiteral("Enter x: "),
            new NewLine(),
            new StringLiteral("Enter y: "),
            new NewLine(),
            new PlaceHolder()
        };
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
            // Case 1: Sum is less than the threshold
            Arguments.of(1, THRESHOLD / 5, "Sum is less than " + THRESHOLD),
            // Case 2: Sum is less than the threshold
            Arguments.of(THRESHOLD / 2, THRESHOLD / 2 - 1, "Sum is less than " + THRESHOLD),
            // Case 3: Sum is exactly the threshold
            Arguments.of(25, 25, "Sum is exactly " + THRESHOLD),
            // Case 4: Sum is more than the threshold
            Arguments.of(THRESHOLD / 2 +1, THRESHOLD / 2, "Sum is more than " + THRESHOLD)
        );
    }

    @Override
    public void runMain() {
        SumToFifty.main(new String[0]);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsCorrectClassification(int x, int y, String expectedFinalMessage) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program did not correctly classify the sum.";
        runWithInput(x + "\n" + y, new Clause[]{
            new StringLiteral(expectedFinalMessage)
        });
    }
}