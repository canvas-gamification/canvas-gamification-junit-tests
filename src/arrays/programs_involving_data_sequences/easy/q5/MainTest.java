package arrays.programs_involving_data_sequences.easy.q5;

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
    // Parsons
    private static final String output = "13 29 66 9 1 4 2 ";
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral(output)
        };
    }

    public void runMain() {
        RevItUp.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(new int[]{11, 37, 84, -29, 14, 4, 9856}, "9856 4 14 -29 84 37 11 "),
                Arguments.of(new int[]{}, ""),
                Arguments.of(new int[]{-47}, "-47 "),
                Arguments.of(new int[]{11, -14, -36}, "-36 -14 11 "),
                Arguments.of(new int[]{-2342, 26534, 462, 58, 4, 0, 0, 0, 235, 259, 4671, 2, 12},
                        "12 2 4671 259 235 0 0 0 4 58 462 26534 -2342"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctReverseMethod(int[] input, String result){
        MethodUtil.invokeIfMethodExists(RevItUp.class, "reverse", new Object[]{input}, int[].class);
        String output = MethodUtil.getMethodOutput();
        assertEquals(result, output, "Your method does not reverse the array correctly.");
    }
}
