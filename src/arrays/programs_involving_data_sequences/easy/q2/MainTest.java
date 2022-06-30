package arrays.programs_involving_data_sequences.easy.q2;

import global.BaseTest;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    private static final int[] numStars = new int[]{1, 3, 5, 7, 9};

    public Clause[] testSentence() {
        return createClausePattern(numStars);
    }

    public void runMain() {
        StarryNight.main(new String[0]);
    }

    private Clause[] createClausePattern(int[] arr) {
        Clause[] c = new Clause[arr.length * 2];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr[i]; j++) {
                sb.append("\\*");
            }
            c[k] = new StringLiteral(sb.toString());
            c[k + 1] = new NewLine();
            k += 2;
        }
        return c;
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(new int[]{4, 9, 0, 1, 3},
                        "****" + System.lineSeparator() + "*********" + System.lineSeparator() + System.lineSeparator() + "*" + System.lineSeparator() + "***"),
                Arguments.of(new int[]{0, 0, 0, 1},"" + System.lineSeparator() + "" + System.lineSeparator() + "" + System.lineSeparator() + "*"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctPrintArrayPatternMethod(int[] input, String pattern) {
        MethodUtil.invokeIfMethodExists(StarryNight.class, "printArrayPattern", new Object[]{input}, int[].class);
        String output = MethodUtil.getMethodOutput();
        assertEquals(pattern, output, "Your method does not correctly print the pattern based on the input array.");
    }

}
