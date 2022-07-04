package arrays.programs_involving_data_sequences.medium.q4;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    private static final int[] array = new int[]{98, 3, 5, 7, 9};
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The array is now: "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        Replacements.main(new String[0]);
    }

    static Stream<Arguments> methodInputProvider(){
        return Stream.of(Arguments.of(new int[]{1, 3, 5, 7, 9}, 98, new int[]{98, 3, 5, 7, 9}),
                Arguments.of(new int[]{}, 11, new int[]{}),
                Arguments.of(new int[]{9563}, -39, new int[]{-39}),
                Arguments.of(new int[]{11, -34, 5, 0, -123, 245, 8876, 2, 1, 5, 4, -457, 10}, -11,
                        new int[]{11, -34, 5, 0, -11, 245, 8876, 2, 1, 5, 4, -457, 10}));
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctAddThisOneMethod(int[] array, int number, int[] replaced) throws Throwable {
        int[] result = (int[]) MethodUtil.invokeIfMethodExists(Replacements.class, "addThisOne",
                new Object[]{array, number}, int[].class, int.class);
        assertArrayEquals(replaced, result, "Your method does not insert the number at the correct index.");
    }

    @Test
    void printsCorrectOutput() throws InvalidClauseException {
        runWithInput("", clauseBuilder(array));
    }

    private static Clause[][] clauseBuilder(int[] array){
        Clause[][] output = new Clause[1][array.length * 2];
        int i = 0;
        for(int item : array){
            output[0][i] = new IntegerLiteral(array[i/2]);
            output[0][i + 1] = new StringLiteral(" ");
            i += 2;
        }
        return output;
    }
}
