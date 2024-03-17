package arrays.multidimensional_arrays.hard.q9;

import global.BaseTest;
import global.MethodTest;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.generateRandomArray;

public class MainTest extends BaseTest {
    // Java

    public static final int n = 3;
    public static final int m = 3;
    public static final int l = 3;
    public static final int up = 100;
    public static final int down = 1;

    public Clause[] testSentence() {
        Clause[] c = new Clause[2 * n * m * l];
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < l; k++) {
                    c[t++] = new RandomInteger(down, up + 1, i + " " + j + " " + k);
                    c[t++] = new StringLiteral(" ");
                }
            }
        }
        return c;
    }

    public void runMain() {
        ImAWholeDimensionAhead.main(new String[0]);
    }

    static Stream<int[][][]> inputProvider() {
        int[][][] test = new int[5][15][10];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 15; j++)
                test[i][j] = generateRandomArray(-1000000000, 1000000000, 10);
        }
        return Stream.of(
                new int[][][]{{{1, 2}, {3, 4}, {5, 6}}, {{2, 1}, {4, 4}, {11, 0}}, {{12, 24}, {31, 44}, {51, 60}}},
                new int[][][]{{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}, {{9, 10}, {11, 12}}},
                test
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctImAWholeDimensionAheadMethod(int[][][] a) throws Throwable {
        String ans = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                for (int k = 0; k < a[i][j].length; k++)
                    ans += a[i][j][k] + " ";
            }
        }
        Clause[] methodSentence = new Clause[]{
                new StringLiteral(ans)
        };
        Object[][] arguments = {
                {a, int[][][].class}
        };
        MethodTest m = new MethodTest(ImAWholeDimensionAhead.class, "imAWholeDimensionAhead", arguments, methodSentence);
        m.setIncorrectMethodStructureErrorMessage("Your imAWholeDimensionAhead does not print the elements of the 3D array correctly.");
        m.callMethod();
    }
}
