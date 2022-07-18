package loops.nested_loops.hard.q8;

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
                new StringLiteral("Enter a number:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain(){PrimeOrdial.main(new String[0]);}

    static Stream<int[]> inputProvider(){
        return Stream.of(new int[]{4, 10, 8, 100, 20, 7}, new int[]{6, 8, 1087}, new int[]{851, 4, 23}, new int[]{-5, -8, -7, -110, 3}, new int[]{0, 3});
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void loopsUntilItEncountersAPrime(int[] n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly loop until it reaches a prime number.";
        StringBuilder s = new StringBuilder();
        for (int x : n) {
            s.append(x).append(" ");
        }
        runWithInput(s.toString(), clauseBuilder(n));
    }

    Clause[][] clauseBuilder(int[] n){
        Clause[][] place = new Clause[1][((n.length-1)*3)+1];
        int count = 0;
        for(int x = 1; x < n.length; x++){
            place[0][count++] = new StringLiteral("Enter another number:");
            place[0][count++] = new Optional(new StringLiteral(" "));
            place[0][count++] = new NewLine();
        }
        place[0][count] = new StringLiteral("Entered a prime number");
        return place;
    }
}
