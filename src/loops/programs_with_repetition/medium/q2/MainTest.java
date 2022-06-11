package loops.programs_with_repetition.medium.q2;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "2";
        return new Clause[]{
                new StringLiteral("Enter an integer:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        VerifiedComposite.main(new String[0]);
    }

    static Stream<Integer> validInputProvider() {
        return Stream.of(267, 2, 3, 1059);
    }

    static Stream<Arguments> invalidInputProvider() {
        return Stream.of(Arguments.of(new int[]{0}, 6), Arguments.of(new int[]{1}, 38), Arguments.of(new int[]{0, 1, -1, -4, -5 -11 ,-57, -2, -558}, 471));
    }

    @ParameterizedTest
    @MethodSource("validInputProvider")
    void worksWithValidInputs(int input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print all the composite numbers between 2 and the input n.";
        ArrayList<Integer> compositeNumbers = compositeNumberList(input);
        Iterator<Integer> it = compositeNumbers.iterator();
        Clause [][] c = new Clause[1][compositeNumbers.size() * 2];
        for(int i = 0; i < c[0].length; i += 2){
            c[0][i] = new IntegerLiteral(it.next());
            c[0][i + 1] = new NewLine();
        }
        runWithInput(String.valueOf(input), c);
    }

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    void worksWithInvalidInputs(int [] invalidInput, int validInput) throws InvalidClauseException{
        TestOption.incorrectStructureErrorMessage = "Your program does not keep asking the user for a number if they enter invalid input.";
        ArrayList<Integer> compositeNumbers = compositeNumberList(validInput);
        Iterator<Integer> it = compositeNumbers.iterator();
        // numberOfClauses is the number of invalid inputs, the valid input, and the number of composite numbers, plus new lines
        int numberOfClauses = 2 * (invalidInput.length + compositeNumbers.size());
        Clause [][] c = new Clause[1][numberOfClauses];
        int i;
        for(i = 0; i < invalidInput.length * 2; i+= 2 ){
            c[0][i] = new StringLiteral("Enter an integer:");
            c[0][i + 1] = new NewLine();
        }
        for(int j = i; j < c[0].length; j += 2){
            c[0][j] = new IntegerLiteral(it.next());
            c[0][j + 1] = new NewLine();
        }
        StringBuilder sb = new StringBuilder();
        for (int j : invalidInput) {
            sb.append(j).append(System.lineSeparator());
        }
        sb.append(validInput);
        runWithInput(sb.toString(), c);
    }

    private static ArrayList<Integer> compositeNumberList(int n) {
        // Returns the composite numbers from 2 to n (inclusive) as an ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            int c = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0)
                    c++;
                if (c > 2) {
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}
