package arrays.multidimensional_arrays.hard.q8;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;

public class MainTest extends BaseTest {
    // Parsons

    public static final int[][] nums = {{41, 52, 63}, {66, 54, 21}, {90, 98, 53}, {1, 2, 3}};

    public Clause[] testSentence() {
        int ans = answer();
        Clause[] c = new Clause[3 * (nums.length + 1)];
        c[0] = new StringLiteral("Swapped Row 1 with Row " + ans);
        c[1] = new Optional(new StringLiteral(" "));
        c[2] = new NewLine();
        for (int i = 0; i < nums.length; i++) {
            String st = "";
            for (int j = 0; j < nums[i].length; j++)
                st += nums[i][j] + " ";
            c[3 * i + 3] = new StringLiteral(st.trim());
            c[3 * i + 4] = new Optional(new StringLiteral(" "));
            c[3 * i + 5] = new NewLine();
        }
        return c;
    }

    public void runMain() {
        LowSumSwap.main(new String[0]);
    }

    public static int answer() {
        int idx = 0, min = 2000000000;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums[i].length; j++)
                sum += nums[i][j];
            if (sum < min) {
                min = sum;
                idx = i;
            }
        }
        int[] temp = nums[0];
        nums[0] = nums[idx];
        nums[idx] = temp;
        return idx + 1;
    }
}