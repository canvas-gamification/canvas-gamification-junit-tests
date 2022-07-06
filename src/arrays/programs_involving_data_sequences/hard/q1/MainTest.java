package arrays.programs_involving_data_sequences.hard.q1;

import global.BaseTest;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MainTest extends BaseTest {
    // Java
    private static final int[] mainMethodOutput = new int[]{0, 1, 0, 2, 3, 1, 0, 2, 0, 3};

    public Clause[] testSentence() {
        return clauseBuilder();
    }

    public void runMain() {
        CountArray.main(new String[0]);
    }

    static Stream<Arguments> methodInputProvider() {
        return Stream.of(Arguments.of(new int[]{1, 5, 5, 3, 9, 8, 1, 4, 3, 7, 6, 9, 0, 1, 4, 5, 5, 5, 5},
                new int[]{1, 3, 0, 2, 2, 6, 1, 1, 1, 2}),
                Arguments.of(new int[]{}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}),
                Arguments.of(new int[]{0, -11, 0, 9, 10, 10, -12, -3, -1, 0, 7, 9, 10, -5, 5, 3},
                        new int[]{3, 0, 0, 1, 0, 1, 0, 1, 0, 2}));
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctCountThisPleaseMethod(int[] input, int[] count) throws Throwable {
        int[] output = (int[]) MethodUtil.invokeIfMethodExists(CountArray.class, "countThisPlease",
                new Object[]{input}, int[].class);
        assertArrayEquals(count, output, "Your method does not correctly count the values in the array.");
    }

    private Clause[] clauseBuilder() {
        Clause[] c = new Clause[mainMethodOutput.length * 2];
        int j = 0;
        for (int i = 0; i < mainMethodOutput.length; i++) {
            c[j++] = new IntegerLiteral(mainMethodOutput[i]);
            c[j++] = new NewLine();
        }
        return c;
    }
}
