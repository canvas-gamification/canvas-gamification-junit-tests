package arrays.multidimensional_arrays.hard.q9;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.arrayToInput;
import static global.utils.ArrayUtil.generateRandomArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java

    public static final int n = 3;
    public static final int m = 3;
    public static final int l = 3;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1 2 3 4 5 6 7 8 18 19 20 21 22 23 24 25 26 9 10 11 12 13 14 15 16 17 27 2 0";
        Clause[] c = new Clause[8 + (n * 2) + (m * 2 * n) + (((l * 2) - 1) * m * n)];
        int t = 0;
        c[t++] = new StringLiteral("Enter the array values:");
        c[t++] = new Optional(new StringLiteral(" "));
        c[t++] = new NewLine();
        c[t++] = new StringLiteral("Enter the array indexes to swap:");
        c[t++] = new Optional(new StringLiteral(" "));
        c[t++] = new NewLine();
        c[t++] = new StringLiteral("\\[");
        for (int i = 0; i < n; i++) {
            c[t++] = new StringLiteral("\\[");
            for (int j = 0; j < m; j++) {
                c[t++] = new StringLiteral("\\[");
                for (int k = 0; k < l; k++) {
                    c[t++] = new IntegerLiteral(i + " " + j + " " + k);
                    if (k == l - 1) {
                        if (j == m - 1)
                            c[t++] = new StringLiteral("\\]");
                        else
                            c[t++] = new StringLiteral("\\], ");
                    } else {
                        c[t++] = new StringLiteral(", ");
                    }
                }
            }
            if (i == n - 1) {
                c[t++] = new StringLiteral("]");
            } else {
                c[t++] = new StringLiteral("], ");
            }
        }
        c[t] = new StringLiteral("]");
        return c;
    }

    public void runMain() {
        ImAWholeDimensionAhead.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        int[][][][] inputs = new int[n][n][m][l];
        int[][] swaps = {{0, 1}, {0, 2}, {2, 1}};
        for(int x = 0; x < n; x ++){
            for(int y = 0; y < n; y ++){
                for(int z = 0; z < m; z++){
                    inputs[x][y][z] = generateRandomArray(0, 100, l);
                }
            }
        }

        return Stream.of(
                Arguments.of(inputs[0], swaps[0]),
                Arguments.of(inputs[1], swaps[1]),
                Arguments.of(inputs[2], swaps[2])
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsCorrectOutput(int[][][] input, int[] swap) throws InvalidClauseException {
        StringBuilder s = new StringBuilder();
        int[][][] answer = new int[n][m][l];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < l; k++) {
                    s.append(input[i][j][k]).append(" ");
                    answer[i][j][k] = input[i][j][k];
                }
            }
        }

        int[][] hold = answer[swap[0]];
        answer[swap[0]] = answer[swap[1]];
        answer[swap[1]] = hold;


        runWithInput(s + " " + arrayToInput(swap));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < l; k++) {
                    assertEquals(answer[i][j][k], Integer.parseInt(getItemByName(i + " " + j + " " + k)),
                            "Your program does not correctly print the output based on the input provided.");
                }
            }
        }
    }
}
