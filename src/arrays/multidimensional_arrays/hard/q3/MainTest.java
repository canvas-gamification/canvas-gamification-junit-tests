package arrays.multidimensional_arrays.hard.q3;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.*;

public class MainTest extends BaseTest {
    // Java

    public static int n = 3;
    public static int down = 1;
    public static int up = 100;

    public Clause[] testSentence() {
        Clause[] c = new Clause[2 * n * n + n + 6];
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
        c[t++] = new StringLiteral("count of odd numbers in array = ");
        c[t++] = new IntegerLiteral("ans");
        c[t] = new Optional(new StringLiteral(" "));
        return c;
    }

    public void runMain() {
        CountsOdd.main(new String[0]);
    }

    public static int oddCount(int[][] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums[i].length; j++)
                if (nums[i][j] % 2 != 0)
                    count++;
        return count;
    }
    @Test
    @RepeatedTest(10)
    public void printsCorrectOutput(){
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                arr[i][j] = Integer.parseInt(getItemByName(i + " " + j));
            }
        }
        CustomAssertions._assertEquals(oddCount(arr), Integer.parseInt(getItemByName("ans")), "Your program does not print the correct number of odd elements in the generated 2D array.");
    }
    static Stream<int[][]> inputProvider() {
        int[][] a1 = new int[10][70];
        for (int i = 0; i < 10; i++)
            a1[i] = generateRandomArray(-100000000, 100000000, 70);
        int[][] a2 = new int[100][100];
        for (int i = 0; i < 100; i++)
            a2[i] = generateRandomArray(-100000000, 100000000, 100);
        int[][] a3 = new int[400][300];
        for (int i = 0; i < 400; i++)
            a3[i] = generateRandomArray(-100000000, 100000000, 300);
        int[][] a4 = {
                {0, 1, 1, 1, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 1, 1}
        };
        return Stream.of(
                a1, a2, a3, a4
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctCountsOddMethod(int[][] input) throws Throwable {
        Clause[] methodSentence = new Clause[]{
                new StringLiteral("count of odd numbers in array = "),
                new IntegerLiteral(oddCount(input))
        };
        Object[][] arguments = {
                {input, int[][].class},
        };
        MethodTest m = new MethodTest(CountsOdd.class, "countsOdd", arguments, methodSentence);
        m.setIncorrectMethodStructureErrorMessage("Your countsOdd method does not correctly count the number of odd elements in the 2D array");
        m.callMethod();
    }
}
