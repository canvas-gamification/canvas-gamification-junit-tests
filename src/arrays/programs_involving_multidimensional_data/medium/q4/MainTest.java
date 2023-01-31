package arrays.programs_involving_multidimensional_data.medium.q4;

import global.BaseRandomTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseRandomTest {
    // Parsons with Distractors

    public static final int n = 5;
    public static final int up = 10;
    public static final int down = 1;

    public Clause[] testSentence() {
        Clause[] c = new Clause[2 * n * n + n + 4];
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new RandomInteger(down, up + 1, i + " " + j);
                c[t++] = new StringLiteral(" ");
            }
            c[t++] = new NewLine();
        }
        c[t++] = new IntegerLiteral("Even");
        c[t++] = new NewLine();
        c[t++] = new IntegerLiteral("Odd");
        c[t] = new NewLine();
        return c;
    }

    public void runMain() {
        OddorEven.main(new String[0]);
    }

    @Test
    public void printsCorrectOutput() {
        int ev = 0, od = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int out = Integer.parseInt(getItemByName(i + " " + j));
                if (out % 2 == 0)
                    ev++;
                else
                    od++;
            }
        }
        CustomAssertions._assertArrayEquals(new int[]{ev, od}, new int[]{Integer.parseInt(getItemByName("Even")), Integer.parseInt(getItemByName("Odd"))},
                "Your program does not correctly count the number of even and odd element in the 2D array.");
    }

    static Stream<Arguments> inputProvider() {
        int[][] t1 = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 1},
                {3, 4, 5, 1, 2},
                {4, 5, 1, 2, 3},
                {5, 1, 2, 3, 4}
        };
        int[][] t2 = {
                {1, 0},
                {0, 1}
        };
        int[][] t3 = {
                {0, 0},
                {0, 0}
        };
        int[][] t4 = {
                {2}
        };
        int[][] t5 = {
                {3}
        };
        return Stream.of(
                Arguments.of(t1, 12, 13),
                Arguments.of(t2, 2, 2),
                Arguments.of(t3, 4, 0),
                Arguments.of(t4, 1, 0),
                Arguments.of(t5, 0, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctAddMatrices(int[][] arr, int even, int odd) throws Throwable {
        TestOption.incorrectStructureErrorMessage = "Your count method does not correctly count the number of odd and even elements in the 2D array.";
        Clause[] c = new Clause[]{
                new StringLiteral("" + even),
                new NewLine(),
                new StringLiteral("" + odd),
                new NewLine()
        };
        Object[][] arguments = {
                {arr, int[][].class}
        };
        MethodTest m = new MethodTest(OddorEven.class, "count", arguments, c);
    }
}
