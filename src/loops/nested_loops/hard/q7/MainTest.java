package loops.nested_loops.hard.q7;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
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

    public void runMain(){BoxMeNow.main(new String[0]);}

    static Stream<Integer> inputProvider(){
        return Stream.of(1, 0, 5, 23, 2);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void constructPatternCorrectly(int n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the box pattern correctly.";
        runWithInput(String.valueOf(n), clauseBuilder(n));
    }

    static Stream<Integer> invalidInputProvider(){return Stream.of(0, -1, -47, -300);}

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    void identifiesInvalidInput(int in) throws InvalidClauseException{
        TestOption.incorrectStructureErrorMessage = "Your program does not identify invalid input.";
        //0 case added in here as well so that if the user marks 0 as invalid input this test will fail and users will
        //have a clearer idea of where the issue is
        String s = in == 0 ? "" : "Invalid input!";
        runWithInput(String.valueOf(in), new Clause[]{
                new StringLiteral(s)
        });
    }

    Clause[][] clauseBuilder(int n){
        Clause[][] place = new Clause[1][n*3];
        StringBuilder s = new StringBuilder();
        int count = 0;
        if(n > 0) {
            s.append("1 ".repeat(n-1));
            s.append("1");
            place[0][count++] = new StringLiteral(s.toString());
            place[0][count++] = new Optional(new StringLiteral(" "));
            place[0][count++] = new NewLine();
        }

        if(n > 2) {
            s = new StringBuilder();
            s.append("1 ");
            s.append("  ".repeat(n - 2));
            s.append("1");

            for (int x = 0; x < n - 2; x++) {
                place[0][count++] = new StringLiteral(s.toString());
                place[0][count++] = new Optional(new StringLiteral(" "));
                place[0][count++] = new NewLine();
            }
        }

        s= new StringBuilder();
        if(n > 1) {
            s.append("1 ".repeat(n-1));
            s.append("1");
            place[0][count++] = new StringLiteral(s.toString());
            place[0][count++] = new Optional(new StringLiteral(" "));
            place[0][count] = new NewLine();
        }

        return place;
    }
}
