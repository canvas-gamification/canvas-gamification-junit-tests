package arrays.multidimensional_arrays.hard.q6;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
    // Parsons

    public static final int[][] nums = {{4, 5, 6}, {66, 54, 21}, {609, 998, 543}};

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Sum of diagonal 1  = "),
                new IntegerLiteral("ans1"),
                new StringLiteral(", Sum of diagonal 2 = "),
                new IntegerLiteral("ans2")
        };
    }

    @Test
    void printsCorrectOutput(){
        int[] ans = answer();
        int s1 = ans[0];
        int s2 = ans[1];
        CustomAssertions._assertEquals(s1, Integer.parseInt(getItemByName("ans1")), "Your program does not correctly print the sum of the diagonals.");
        CustomAssertions._assertEquals(s2, Integer.parseInt(getItemByName("ans2")), "Your program does not print the correct sum of the diagonals.");
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
