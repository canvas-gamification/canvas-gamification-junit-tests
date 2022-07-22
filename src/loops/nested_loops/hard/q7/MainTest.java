package loops.nested_loops.hard.q7;

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

    public void runMain(){BoxMeNow.main(new String[0]);}

    static Stream<Integer> inputProvider(){
        return Stream.of(1, 0, 5, 23, 2);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void constructPatternCorrectly(int n) throws InvalidClauseException {
        runWithInput(String.valueOf(n), clauseBuilder(n));
    }

    static Stream<Integer> invalidInputProvider(){return Stream.of(-1, -47, -300);}

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    void identifiesInvalidInput(int in) throws InvalidClauseException{
        runWithInput(String.valueOf(in), new Clause[]{
                new StringLiteral("Invalid input!")
        });
    }

    Clause[] clauseBuilder(int n){
        Clause[] place = new Clause[1];
        StringBuilder s = new StringBuilder();
        if(n > 0) {
            s.append("1".repeat(n));
            s.append(System.lineSeparator());
        }
        for(int x = 0; x < n-2; x ++){
            s.append("1");
            s.append(" ".repeat(n-2));
            s.append("1");
            s.append(System.lineSeparator());
        }
        if(n > 1) {
            s.append("1".repeat(n));
            s.append(System.lineSeparator());
        }
        place[0] = new StringLiteral(s.toString());
        return place;
    }
}
