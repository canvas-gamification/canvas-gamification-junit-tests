package arrays.multidimensional_arrays.hard.q3;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;

public class MainTest extends BaseTest {
    // Java

    public static int n = 3;
    public static int down = 1;
    public static int up = 100;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1 2";
        Clause[] c = new Clause[2 * n * n + n + 9];
        int t = 0;
        c[t++] = new StringLiteral("Generated array:");
        c[t++] = new Optional(new StringLiteral(" "));
        c[t++] = new NewLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new RandomInteger(down, up + 1, i + " " + j);
                if (j != n - 1)
                    c[t++] = new StringLiteral(" ");
                else
                    c[t++] = new Optional(new StringLiteral(" "));
            }
            c[t++] = new NewLine();
        }
        c[t++] = new StringLiteral("Enter two limits for the indices:");
        c[t++] = new Optional(new StringLiteral(" "));
        c[t++] = new NewLine();
        c[t++] = new StringLiteral("count of odd numbers in array = ");
        c[t++] = new IntegerLiteral("ans");
        c[t] = new Optional(new StringLiteral(" "));
        return c;
    }

    public void runMain() {
        CountsOdd.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(n, n),
                Arguments.of(1, 1),
                Arguments.of(0, 0),
                Arguments.of(n - 1, n - 1),
                Arguments.of(n / 2, n / 2)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsCorrectOutput(int a, int b) throws InvalidClauseException {
        runWithInput(a + " " + b);
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(getItemByName(i + " " + j));
            }
        }
        int ans = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (arr[i][j] % 2 != 0)
                    ans++;
            }
        }
        _assertEquals(ans, Integer.parseInt(getItemByName("ans")),
                "Your program does not print the correct number of odd elements in the generated 2D array.");
    }
}
