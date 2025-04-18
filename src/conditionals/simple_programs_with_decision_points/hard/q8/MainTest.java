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
    
    @Override
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1\n2";
        
        return new Clause[]{
            new StringLiteral("Enter x "),
            new Optional(new StringLiteral(" ")),
            new NewLine(),
            new StringLiteral("Enter y "),
            new Optional(new StringLiteral(" ")),
            new NewLine(),
            new PlaceHolder()
        };
    }
    
    static Stream<Arguments> inputProvider() {
        return Stream.of(
            // Case 1: 1 + 10 = 11, which is less than 50.
            Arguments.of(1, 10, "Sum is less than 50"),
            // Case 2: 25 + 25 = 50, exactly 50.
            Arguments.of(25, 25, "Sum is exactly 50"),
            // Case 3: 30 + 25 = 55, which is more than 50.
            Arguments.of(30, 25, "Sum is more than 50")
        );
    }
    
    @Override
    public void runMain() {
        sumToFifty.main(new String[0]);
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
