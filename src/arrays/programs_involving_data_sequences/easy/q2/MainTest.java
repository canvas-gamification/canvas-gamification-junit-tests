package arrays.programs_involving_data_sequences.easy.q2;

import global.BaseTest;
import global.MethodTest;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
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

    static Stream<int[]> inputProvider() {
        return Stream.of(new int[]{4, 9, 0, -1, 3},
                new int[]{0, 0, 0, 1},
                ArrayUtil.generateRandomArray(0, 150, 20),
                new int[]{});
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctPrintArrayPatternMethod(int[] input) throws Throwable {
        Clause[] c = new Clause[2 * input.length];
        int t = 0;
        for (int i = 0; i < input.length; i++) {
            String st = "";
            for (int j = 0; j < input[i]; j++)
                st += "\\*";
            c[t++] = new StringLiteral(st);
            if (i != input.length - 1)
                c[t++] = new NewLine();
            else
                c[t++] = new Optional(new NewLine());

        }
        Object[][] arguments = {
                {input, int[].class}
        };
        TestOption.incorrectStructureErrorMessage = "Your printArrayPattern method does not correctly print the pattern based on the input array.";
        MethodTest m = new MethodTest(StarryNight.class, "printArrayPattern", arguments, c);
        m.callMethod();
    }

}
