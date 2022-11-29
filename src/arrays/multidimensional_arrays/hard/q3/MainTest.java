package arrays.multidimensional_arrays.hard.q3;

import global.BaseTest;
import global.MethodTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.*;

public class MainTest extends BaseTest {
    // Parsons

    public static int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("count of odd numbers in array = "),
                new IntegerLiteral(oddCount(arr))

        };
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

    static Stream<int[][]> inputProvider() {
        int[][] a1 = new int[100][100];
        for(int i = 0; i < 100; i ++)
            a1[i] = generateRandomArray(1, 100000000, 100);
        int[][] a2 = new int[100][100];
        for(int i = 0; i < 100; i ++)
            a2[i] = generateRandomArray(1, 100000000, 100);
        int[][] a3 = new int[100][100];
        for(int i = 0; i < 100; i ++)
            a3[i] = generateRandomArray(1, 100000000, 100);
        return Stream.of(
                a1, a2, a3
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
