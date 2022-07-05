package arrays.programs_involving_data_sequences.medium.q5;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
            new PlaceHolder()
        };
    }

    public void runMain() {
        DoTheDelete.main(new String[0]);
    }

    static Stream<Arguments> methodInputProvider(){
        return Stream.of(Arguments.of(new int[]{3, 4, 5, 0, -11, 3, 3, 1, 5, 3}, 3, 9));
    }

    static Stream<Arguments> mainMethodInputProvider(){
        return Stream.of(Arguments.of(new int[]{0, 4, 5, 0, -11, 0, 0, 1, 5, 0}));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctDeleteThisMethod(int[] input, int replace){

    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsCorrectOutput(int[] output) throws InvalidClauseException {
        runWithInput("", clauseBuilder(output));
    }

    private static Clause[][] clauseBuilder(int[] array){
        Clause[][] c = new Clause[1][array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++){
            c[0][j] = new IntegerLiteral(array[j]);
            c[0][j + 1] = new StringLiteral(" ");
            j += 2;
        }
        return c;
    }

}
