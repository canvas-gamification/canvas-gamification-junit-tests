package arrays.programs_involving_multidimensional_data.easy.q4;

import global.BaseRandomTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.*;

public class MainTest extends BaseRandomTest {

    public static int n = 4;
    public static int up = 100;
    public static int down = 0;
    public Clause[] testSentence() {
        Clause[] c = new Clause[4 * n * n + 4];
        c[0] = new StringLiteral("Before the rotation:");
        c[1] = new NewLine();
        for(int i = 2; i < 2 * n * n + 2; i += 2){
            c[i] = new RandomInteger(down, up, "" + ((i - 2)/2));
            c[i + 1] = new NewLine();
        }
        c[2 * n * n + 2] = new StringLiteral("After the rotation:");
        c[2 * n * n + 3] = new NewLine();
        for(int i = 2 * n * n + 4; i < 4 * n * n + 4; i += 2){
            c[i] = new IntegerLiteral("x" + (((i - 2 * n * n + 4) - 2) / 2));
            c[i + 1] = new NewLine();
        }
        return c;
    }

    public void runMain() {
        Rotation.main(new String[0]);
    }

    public static int[] answerFor(int[] arr) {
        int a = arr[0], b = arr[n - 1], c = arr[n * n - 1], d = arr[n * n - n];
        arr[n - 1] = a;
        arr[n * n - 1] = b;
        arr[n * n - n] = c;
        arr[0] = d;
        return arr;

    }

    void printsCorrectOutput(){
        int[] arr = new int[n * n];
        for(int i = 0; i < n * n; i ++){
            arr[i] = Integer.parseInt(getItemByName("" + i));
        }
        int[] ans = answerFor(arr);
        int[] in = new int[n * n];
        for(int i = 0; i < n * n; i ++){
            in[i] = Integer.parseInt(getItemByName("x" + i));
        }
        CustomAssertions._assertArrayEquals(ans, in, "Your program does not rotated the 2D array correctly.");


    }
}