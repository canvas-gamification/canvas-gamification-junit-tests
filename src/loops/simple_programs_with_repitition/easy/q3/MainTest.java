package loops.simple_programs_with_repitition.easy.q3;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
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
        TestOption.defaultInput = "7";
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain(){TimeTheTable.main(new String[0]);}

    static Stream<Integer> inputProvider(){
        return Stream.of(5, 15, 207, 0, -5, 1);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsPatternCorrectly(Integer n) throws InvalidClauseException {
        runWithInput(String.valueOf(n), clauseBuilder(n));
    }

    Clause[][] clauseBuilder(int n){
        Clause[][] place = new Clause[1][29];
        int count = 0;
        for(int x = 1; x <= 9; x++){
            place[0][count++] = new StringLiteral(n + " \\* " + x + " = ");
            place[0][count++] = new IntegerLiteral();
            place[0][count++] = new NewLine();
        }
        place[0][count++] = new StringLiteral(n + " \\* 10 = ");
        place[0][count] = new IntegerLiteral();
        return place;
    }
}
