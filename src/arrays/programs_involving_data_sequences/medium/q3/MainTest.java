package arrays.programs_involving_data_sequences.medium.q3;

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
    // Parsons with distractors
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1 2 3 4 5 6 7 8 9 10";
        return new Clause[]{
                new PlaceHolder()
        };
    }

    public void runMain() {
        BuildAnArray.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("-1", "", 1),
                Arguments.of("7 8 11 -56 0 -1", "7 8 11 -56 0 ", 6),
                Arguments.of("7 8 11 -34 2 1 -2 0 9 486523", "7 8 11 -34 2 1 -2 0 9 486523 ", 10),
                Arguments.of("-492 5 0 3542 -23 -23442 1 0 987 -1", "-492 5 0 3542 -23 -23442 1 0 987 ", 10),
                Arguments.of("1 456 7229 -343 4675434 3454 587 -8414 -845 2467 2 0 648 7 5 978", "1 456 7229 -343 4675434 3454 587 -8414 -845 2467 ", 10)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void createsAndPrintsArrayCorrectly(String input, String output, int length) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly prompt the user for up to ten values and then print the resulting array.";
        runWithInput(input, clauseBuilder(length, output));
    }

    private Clause[][] clauseBuilder(int size, String output) {
        Clause[][] c = new Clause[1][size * 2 + 1];
        for (int i = 0; i < c[0].length - 1; i += 2) {
            c[0][i] = new StringLiteral("Enter a value to insert into the array \\( -1 to exit \\): ");
            c[0][i + 1] = new NewLine();
        }
        c[0][size * 2] = new StringLiteral(output);
        return c;
    }

}
