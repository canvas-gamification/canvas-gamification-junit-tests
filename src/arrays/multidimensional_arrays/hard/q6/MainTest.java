package arrays.multidimensional_arrays.hard.q6;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;

public class MainTest extends BaseTest {
    // Parsons

    public static final int[][] nums = {{4, 5, 6}, {66, 54, 21}, {609, 998, 543}};

    public Clause[] testSentence() {
        int[] ans = answer();
        int s1 = ans[0];
        int s2 = ans[1];
        return new Clause[]{
                new StringLiteral("Sum of diagonal 1  = " + s1 + ", Sum of diagonal 2 = " + s2)
        };
    }

    public void runMain() {
        SumDiags.main(new String[0]);
    }

    public static int[] answer() {
        int x = 0, y = 0;
        for (int i = 0; i < nums.length; i++) {
            x += nums[i][i];
        }
        for (int i = 0; i < nums.length; i++) {
            y += nums[i][nums.length - i - 1];
        }
        return new int[]{x, y};
    }
}