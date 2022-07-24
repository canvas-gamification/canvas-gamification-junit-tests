package loops.nested_loops.hard.q6;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5";
        return new Clause[]{
                new StringLiteral("Enter number of lines:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain(){TryAngleButBothWaysAKAPyramid.main(new String[0]);}

    static Stream<Integer> inputProvider(){
        return Stream.of(5, 1, 0, 10, 42);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsPyramidCorrectly(int n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program printed the pattern incorrectly.";
        runWithInput(String.valueOf(n), clauseBuilder(n));
    }

    Clause[][] clauseBuilder(int n){
        Clause[][] place = new Clause[1][n*3];
        int count = 0;
        for(int x = 0; x <n; x++){
            StringBuilder s = new StringBuilder();
            s.append(" ".repeat(n - x - 1));
            place[0][count++] = new StringLiteral(s.toString());
            s = new StringBuilder();
            for(int y = x+1; y > 0; y--){
                s.append(y);
            }
            for(int y = 2; y <= x+1; y++){
                s.append(y);
            }
            place[0][count++] = new StringLiteral(s.toString());
            place[0][count++] = new NewLine();
        }
        return place;
    }

    static Stream<String> invalidInputProvider(){return Stream.of("-1", "-7", "-7634");}

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    void identifiesInvalidInput(String n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify invalid input";
        runWithInput(n, new Clause[]{
                new StringLiteral("Invalid input!")
        });
    }
}
