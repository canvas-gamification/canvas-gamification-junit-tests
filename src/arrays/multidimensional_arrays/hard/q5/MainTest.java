package arrays.multidimensional_arrays.hard.q5;

import global.BaseTest;
import global.MethodTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons

    public static int[][] arr = {{4, 5, 6}, {66, 54, 21}, {609, 998, 543}, {1111, 2342, 4583, 1738}};

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The 2D array has the sum of "),
                new IntegerLiteral(sum(arr)),
                new StringLiteral(" and the average of "),
                new DoubleLiteral(avg(arr), avg(arr) + 0.001),
                new StringLiteral(".")
        };
    }

    public void runMain() {
        SumAverageProgram.main(new String[0]);
    }

    public static int sum(int[][] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums[i].length; j++)
                sum += nums[i][j];
        return sum;
    }

    public static double avg(int[][] nums) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums[i].length; j++) {
                sum += nums[i][j];
                count++;
            }
        double avg = sum / count;
        return avg;
    }

    static Stream<int[][]> InputProvider() {
        int[][] a1 = new int[100][100];
        for (int i = 0; i < 100; i++)
            a1[i] = generateRandomArray(1, 100000000, 100);
        int[][] a2 = new int[100][100];
        for (int i = 0; i < 100; i++)
            a2[i] = generateRandomArray(1, 100000000, 100);
        int[][] a3 = new int[100][100];
        for (int i = 0; i < 100; i++)
            a3[i] = generateRandomArray(1, 100000000, 100);
        return Stream.of(
                a1, a2, a3
        );
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void correctSumArrayMethod(int[][] input) throws Throwable {
        Object[][] arguments = {
                {input, int[][].class},
        };
        MethodTest m = new MethodTest(SumAverageProgram.class, "SumArray", arguments);
        m.setIncorrectMethodStructureErrorMessage("Your SumArray method does not return the correct sum of elements of a 2D array");
        Object output = m.callMethod();
        assertEquals(sum(input), (int) output);
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void correctAvgArrayMethod(int[][] input) throws Throwable {
        Object[][] arguments = {
                {input, int[][].class},
        };
        MethodTest m = new MethodTest(SumAverageProgram.class, "AvgArray", arguments);
        m.setIncorrectMethodStructureErrorMessage("Your AvgArray method does not return the correct average of elements of a 2D array");
        Object output = m.callMethod();
        assertEquals(avg(input), (double) output, 0.001);
    }
}
