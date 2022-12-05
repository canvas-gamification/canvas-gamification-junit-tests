package arrays.multidimensional_arrays.hard.q6;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;

public class MainTest extends BaseTest {
    // Parsons

    public static final int [][] a = { {4, 5, 6}, {66, 54, 21}, {609, 998, 543}, {1111, 2342, 4583}  };
    public static final int [][] b = { {4433, 2316, 9879}, {662, 154, 721}, {69, 98, 54},{1, 4, 3}  };

    public Clause[] testSentence() {
        if(a.length != b.length || a[0].length != b[0].length) {
            return new Clause[]{
                    new StringLiteral("Can't add because arrays of different sizes!")
            };
        }
        else{
            Clause[] c = new Clause[3 * a.length];
            int[][] ans = answerFor(a, b);
            for(int i = 0; i < a.length; i ++){
                String st = "";
                for(int j = 0; j < a[0].length; j ++){
                    st += ans[i][j] + " ";
                }
                c[3 * i] = new StringLiteral(st.trim());
                c[3 * i + 1] = new Optional(new StringLiteral(" "));
                c[3 * i + 2] = new NewLine();
            }
            return c;
        }
    }

    public void runMain() {
        OneAndOneMakeTwoDArrays.main(new String[0]);
    }

    public static int[][] answerFor(int[][] x, int[][] y){
        int[][] ans = new int[x.length][x[0].length];
        for(int i = 0; i < x.length; i ++){
            for(int j = 0; j < x[0].length; j ++)
                ans[i][j] = x[i][j] + y[i][j];
        }
        return ans;
    }
}
