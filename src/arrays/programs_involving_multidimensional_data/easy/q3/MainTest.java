package arrays.programs_involving_multidimensional_data.easy.q3;

import global.BaseRandomTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseRandomTest {
    // Parsons

    public static int n = 3;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "";
        Clause[] c = new Clause[2 * n * n + n + 1];
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new RandomInteger(0, 2, i + " " + j);
                c[t++] = new StringLiteral(" ");
            }
            c[t++] = new NewLine();
        }
        c[t] = new PlaceHolder();
        return c;
    }

    public void runMain() {
        Identities.main(new String[0]);
    }

    public static boolean answerFor(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if ((i == j && arr[i][j] != 1) || (i != j && arr[i][j] != 0))
                    return false;
            }
        }
        return true;
    }

    @Test
    public void printsCorrectOutput() throws InvalidClauseException {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(getItemByName(i + " " + j));
            }
        }
        boolean ans = answerFor(arr);
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print if the matrix is an identity matrix.";
        runWithInput("", new Clause[]{
                new StringLiteral("" + ans)
        });
    }

    static Stream<Arguments> inputProvider() {
        int[][] t1 = new int[][]{
                {1, 0},
                {0, 1}
        };
        int[][] t2 = new int[][]{
                {1}
        };
        int[][] t3 = new int[][]{
                {0}
        };
        int[][] t4 = new int[][]{
                {0, 0, 1},
                {0, 1, 0},
                {1, 0, 0}
        };
        int[][] t5 = new int[][]{
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        };
        int[][] t6 = new int[][]{
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1}
        };
        int[][] t7 = new int[][]{
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}
        };
        return Stream.of(
                Arguments.of(t1, true),
                Arguments.of(t2, true),
                Arguments.of(t3, false),
                Arguments.of(t4, false),
                Arguments.of(t5, false),
                Arguments.of(t6, false),
                Arguments.of(t7, true)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctCheckMatrix(int[][] arr, boolean ans) throws Throwable {
        Object[][] arguments = {
                {arr, int[][].class}
        };
        MethodTest m = new MethodTest(Identities.class, "checkMatrix", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(ans, output, "Your checkMatrix method does not correctly identify an identity matrix.");
    }

}
