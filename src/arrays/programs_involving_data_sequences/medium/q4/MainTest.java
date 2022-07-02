package arrays.programs_involving_data_sequences.medium.q4;

import global.BaseTest;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The index the number was added at is: "),
                new IntegerLiteral("index")
        };
    }

    public void runMain() {
        Replacements.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(new int[]{1, 3, 5, 7, 9}, 98, 0));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctAddThisOneMethod(int[] array, int number, int index) throws Throwable {
        int result = (int) MethodUtil.invokeIfMethodExists(Replacements.class, "addThisOne",
                new Object[]{array, number}, int[].class, int.class);
        assertEquals(index, result, "Your method does not add the number at the correct index.");
    }
}
