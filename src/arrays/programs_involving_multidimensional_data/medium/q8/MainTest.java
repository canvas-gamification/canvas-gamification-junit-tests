package arrays.programs_involving_multidimensional_data.medium.q8;

import global.BaseRandomTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseRandomTest {
    // Parsons with Distractors

    public static final int n = 10;
    public static final int m = 10;
    public static final int up = 1000;
    public static final int down = 1;

    public Clause[] testSentence() {
        Clause[] c = new Clause[2 * n * m + n + 5];
        int t = 0;
        c[t++] = new StringLiteral("Random number: ");
        c[t++] = new RandomInteger(down, up + 1, "num");
        c[t++] = new NewLine();
        c[t++] = new StringLiteral("The 2D array of square root is:");
        c[t++] = new NewLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[t++] = new DoubleLiteral(i + " " + j);
                c[t++] = new StringLiteral(" ");
            }
            c[t++] = new NewLine();
        }
        return c;
    }

    public void runMain() {
        IdenticalGen.main(new String[0]);
    }

    @Test
    public void printsCorrectOutput() {
        double num = Math.sqrt(Double.parseDouble(getItemByName("num")));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                CustomAssertions._assertEquals(num, Double.parseDouble(getItemByName(i + " " + j)),
                        "Your program does not print the correct 2D square root array.");
            }
        }
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(16, 5, 7),
                Arguments.of(32, 2, 10),
                Arguments.of(1000001, 10, 10),
                Arguments.of(23, 24, 25),
                Arguments.of(1, 1, 1),
                Arguments.of(0, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctSquareRootMethod(int num, int n, int m) throws Throwable {
        Object[][] arguments = {
                {num, int.class},
                {n, int.class},
                {m, int.class}
        };
        MethodTest test = new MethodTest(IdenticalGen.class, "squareRoot", arguments);
        Object output = test.callMethod();
        double[][] ans = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                ans[i][j] = Math.sqrt(num);
        }
        CustomAssertions._assertArrayEquals(ans, output, "Your squareRoot method does not return the correct 2D array based on the input parameters.");
    }
}
