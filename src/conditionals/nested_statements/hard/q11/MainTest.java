package conditionals.nested_statements.hard.q11;

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
        TestOption.defaultInput = "Red\nSpicy";
        return new Clause[]{
                new StringLiteral("Enter color: "),
                new NewLine(),
                new StringLiteral("Enter taste: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    @Override
    public void runMain() {
        FruitIdentifier.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Red\nSweet", "Apple"),
                Arguments.of("Red\nSpicy", "Chili"),
                Arguments.of("Red\nBitter", "Not found"),
                Arguments.of("Yellow\nSweet", "Banana"),
                Arguments.of("Yellow\nSpicy", "Not found"),
                Arguments.of("Yellow\nSour", "Not found"),
                Arguments.of("Blue\nSweet", ""), 
                Arguments.of("Green\nSpicy", "")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testFruitIdentification(String input, String expectedOutput) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct item for the given color and taste.";
        runWithInput(input, new Clause[]{
                new StringLiteral(expectedOutput)
        });
    }
}

