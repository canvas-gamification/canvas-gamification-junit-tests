package loops.nested_loops.hard.q6;

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

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(5), Arguments.of(1), Arguments.of(0), Arguments.of(10));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsPyramidCorrectly(int n) throws InvalidClauseException {
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
        runWithInput(String.valueOf(n), place);
    }
}
