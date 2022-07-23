package loops.simple_programs_with_repitition.easy.q2;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "2";
        return new Clause[]{
                new StringLiteral("Enter either 1, 2, 3, 4: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain(){VirtualBouncer.main(new String[0]);}

    static Stream<int[]> inputProvider(){
        return Stream.of(new int[]{5, 8, 10, 11, 6, 23, 1}, new int[]{-1, -2, -3, 2}, new int[]{2});
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void loopsUntilSpecifiedNumbersAreEntered(int[] n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not loop until a valid is entered.";
        StringBuilder s = new StringBuilder();
        for(int x : n){
            s.append(x).append(" ");
        }
        runWithInput(s.toString(), clauseBuilder(n));
    }

    Clause[] clauseBuilder(int[] n){
        StringBuilder s = new StringBuilder();
        for(int x = 0; x < n.length-1; x++){
            s.append("Please only enter either 1, 2, 3, or 4: ");
            s.append(System.lineSeparator());
        }
        s.append("You entered a valid number!");
        return new Clause[]{
                new StringLiteral(s.toString())
        };
    }
}
