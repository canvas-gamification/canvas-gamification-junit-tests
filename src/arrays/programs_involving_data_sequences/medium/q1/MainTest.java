package arrays.programs_involving_data_sequences.medium.q1;

import global.BaseTest;
import global.utils.MethodUtil;
import global.variables.Clause;
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
            new StringLiteral("24601")
        };
    }

    public void runMain() {
        Stringify.main(new String[0]);
    }

    static Stream<Arguments> methodInputProvider(){
        return Stream.of(Arguments.of(new int[]{2, 4, 6, 0, 1}, "24601"), Arguments.of(new int[]{}, ""),
                Arguments.of(new int[]{-11, 12, 37, 11, 0, 0, 0, -39, 345}, "-11123711000-39345"),
                Arguments.of(new int[]{1}, "1"));
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctIntoStringMethod(int[] input, String result) throws Throwable {
        String output = (String) MethodUtil.invokeIfMethodExists(Stringify.class, "intoString", new Object[]{input}, int[].class);
        assertEquals(result, output, "Your method does not correctly convert the array into a String.");
    }
}
