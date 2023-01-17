package arrays.programs_involving_multidimensional_data.easy.q4;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.generateRandomArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseRandomTest {

    public static int n = 2;

    public Clause[] testSentence() {
        Clause[] c = new Clause[2];
        c[0] = new StringLiteral("Before the rotation:");
        c[1] = new NewLine();

         return c;
    }

    public void runMain() {
        Rotation.main(new String[0]);
    }

    int[][] answerFor(int[][] arr) {
        int a = arr[0][0], b = arr[0][n - 1], c = arr[n - 1][n - 1], d = arr[n - 1][0];
        int[][] ans = arr.clone();
        ans[0][0] = b;
        ans[0][n - 1] = c;
        ans[n - 1][n - 1] = d;
        ans[n - 1][0] = a;
        return ans;
    }

    /*void printsCorrectOutput(){
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                arr[i][j] = Integer.parseInt(getItemByName(i + " " + j));
            }
        }
        int[][] ans = answerFor(arr);
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                assertEquals(ans[i][j], Integer.parseInt(getItemByName("x" + i + " " + j)));
            }
        }
    }*/
}