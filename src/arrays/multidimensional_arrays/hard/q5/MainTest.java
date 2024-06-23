package arrays.multidimensional_arrays.hard.q5;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;

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
        for (int[] num : nums)
            for (int i : num) sum += i;
        return sum;
    }

    public static double avg(int[][] nums) {
        double count = 0;
        int sum = 0;
        for (int[] num : nums)
            for (int j = 0; j < num.length; j++) {
                sum += num[j];
                count++;
            }
        return sum / count;
    }
}
