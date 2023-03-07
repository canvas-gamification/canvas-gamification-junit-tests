package arrays.programs_involving_multidimensional_data.hard.q3;

import global.BaseRandomTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.generateRandomArray;

public class MainTest extends BaseRandomTest {
    // Java

    public static final int n = 8;
    public static final int up = 10;
    public static final int down = 0;

    public Clause[] testSentence() {
        Clause[] c = new Clause[2 * n * n + n + 11];
        int t = 0;
        c[t++] = new StringLiteral("Generated 2D array:");
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
        c[t++] = new StringLiteral("Generated index: ");
        c[t++] = new IntegerLiteral("index");
        c[t++] = new NewLine();
        c[t++] = new StringLiteral("The value at index ");
        c[t++] = new IntegerLiteral("index2");
        c[t++] = new StringLiteral(" is: ");
        c[t++] = new IntegerLiteral("ans");
        c[t] = new Optional(new NewLine());
        return c;
    }

    public void runMain() {
        EightByEight.main(new String[0]);
    }

    @Test
    @RepeatedTest(10)
    public void printsCorrectOutput() {
        int index = Integer.parseInt(getItemByName("index"));
        CustomAssertions._assertEquals(index, Integer.parseInt(getItemByName("index2")),
                "Your program does not print the correct output in correct structure.");
        int x = index / n, y = index % n;
        CustomAssertions._assertEquals(Integer.parseInt(getItemByName(x + " " + y)), Integer.parseInt(getItemByName("ans")),
                "Your program does not correctly print the corresponding element of the index in the 2D array.");
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
                {2}
        };
        int[][] t4 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] t5 = new int[50][50];
        for (int i = 0; i < 50; i++) {
            t5[i] = generateRandomArray(down, up + 1, 50);
        }
        int[][] t6 = new int[50][50];
        for (int i = 0; i < 50; i++) {
            t6[i] = generateRandomArray(down, up + 1, 50);
        }
        return Stream.of(
                Arguments.of(t1, 12, 5),
                Arguments.of(t1, 4, 5),
                Arguments.of(t1, 24, 4),
                Arguments.of(t2, 1, 0),
                Arguments.of(t3, 0, 2),
                Arguments.of(t4, 14, 15),
                Arguments.of(t5, 99, t5[99 / 50][99 % 50]),
                Arguments.of(t5, 1010, t5[1010 / 50][1010 % 50]),
                Arguments.of(t6, 2499, t6[2499 / 50][2499 % 50]),
                Arguments.of(t6, 50, t6[1][0])
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctFindMethod(int[][] arr, int idx, int ans) throws Throwable {
        Object[][] arguments = {
                {arr, int[][].class},
                {idx, int.class}
        };
        MethodTest m = new MethodTest(EightByEight.class, "find", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(ans, output, "Your find method does not correctly return the corresponding element of the index in the 2D array.");
    }
}
