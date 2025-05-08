package conditionals.programs_with_decision_points.hard.q13;

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
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1\n1";

        return new Clause[]{
                new StringLiteral("Select book color: \\(1 - Pink, 2 - Blue, 3 - Green\\)"),
                new NewLine(),
                new StringLiteral("Select book genre: \\(1 - Fiction, 2 - Non-Fiction, 3 - Mystery\\)"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    static Stream<Arguments> InputProvider() {
        return Stream.of(
                Arguments.of(1, 1, "You selected a Pink Fiction book."),
                Arguments.of(1, 2, "You selected a Pink Non-Fiction book."),
                Arguments.of(1, 3, "You selected a Pink Mystery book."),
                Arguments.of(2, 1, "You selected a Blue Fiction book."),
                Arguments.of(2, 2, "You selected a Blue Non-Fiction book."),
                Arguments.of(2, 3, "You selected a Blue Mystery book."),
                Arguments.of(3, 1, "You selected a Green Fiction book."),
                Arguments.of(3, 2, "You selected a Green Non-Fiction book."),
                Arguments.of(3, 3, "You selected a Green Mystery book."),
                Arguments.of(1, 4, "Invalid selection."),
                Arguments.of(2, 5, "Invalid selection."),
                Arguments.of(3, 0, "Invalid selection."),
                Arguments.of(4, 1, "Invalid selection."),
                Arguments.of(-1, 2, "Invalid selection."),
                Arguments.of(7, 7, "Invalid selection.")
        );
    }

    public void runMain() {
        Bookstore.main(new String[0]);
    }

    @ParameterizedTest
    @MethodSource("ValidInputProvider")
    void printsCorrectBookSelection(int color, int genre, String expectedOutput) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the book selection.";
        runWithInput(color + "\n" + genre, new Clause[]{
           new StringLiteral(expectedOutput)
    });
}
    
    @ParameterizedTest
    @MethodSource("InvalidInputProvider")
    void handlesInvalidInput(int color, int genre, String expectedError) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly handle invalid input.";
        runWithInput(color + "\n" + genre, new Clause[]{
            new StringLiteral(expectedError)
    });
}
}
