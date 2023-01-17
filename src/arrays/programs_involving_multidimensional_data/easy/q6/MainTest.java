package arrays.programs_involving_multidimensional_data.easy.q6;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons

    public static int[][] arr = {{2, 3, 4}, {16, 20, 32}};
    public static int r = 20;

    public Clause[] testSentence() {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly modify the values to inbetween 0 and " + (r - 1);
        Clause[] c = new Clause[arr.length * arr[0].length * 2];
        int[][] ans = answerFor(arr);
        for(int i = 0; i < arr.length * arr[0].length; i ++){
            c[2 * i] = new StringLiteral("" + ans[i / arr[0].length][i % arr[0].length]);
            c[2 * i + 1] = new NewLine();
        }
        return c;
    }

    public void runMain() {
        ValueLock.main(new String[0]);
    }

    public static int[][] answerFor(int[][] a){
        int[][] ans = a.clone();
        for(int i = 0; i < ans.length; i ++){
            for(int j = 0; j < ans[0].length; j ++)
                ans[i][j] %= r;
        }
        return ans;
    }
}