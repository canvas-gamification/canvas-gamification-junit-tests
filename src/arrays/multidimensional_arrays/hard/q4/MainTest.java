package arrays.multidimensional_arrays.hard.q4;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;

public class MainTest extends BaseTest {
    // Parsons

    public static int[][] arr = {{4, 5, 6}, {66, 54, 21}, {609, 998, 543}, {1111, 2342, 4583}};

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral(answerFor(arr))
        };
    }

    public void runMain() {
        AlterTable.main(new String[0]);
    }

    public static String answerFor(int[][] nums) {
        int count = 0;
        String ans = "";
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (count % 2 == 0)
                    ans += nums[i][j] + " ";
                count++;
            }
        }
        return ans;
    }
}
