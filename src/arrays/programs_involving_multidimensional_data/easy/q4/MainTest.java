package arrays.programs_involving_multidimensional_data.easy.q4;

import global.BaseRandomTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseRandomTest {

    public static int n = 4;
    public static int up = 100;
    public static int down = 0;
    public Clause[] testSentence() {
        Clause[] c = new Clause[4 * n * n + 4];
        int p = 0;
        c[p++] = new StringLiteral("Before the rotation:");
        c[p++] = new NewLine();
        for(int i = 0; i < n * n; i++){
            c[p++] = new RandomInteger(down, up, "" + i);
            c[p++] = new NewLine();
        }
        c[p++] = new StringLiteral("After the rotation:");
        c[p++] = new NewLine();
        for(int i = 0; i < n * n; i++){
            c[p++] = new IntegerLiteral("x" + i);
            c[p++] = new NewLine();
        }
        return c;
    }

    public void runMain() {
        Rotation.main(new String[0]);
    }

    public static int[] answerFor(int[] arr) {
        int sz = (int)Math.sqrt(arr.length);
        int a = arr[0], b = arr[sz - 1], c = arr[sz * sz - 1], d = arr[sz * sz - sz];
        arr[sz - 1] = a;
        arr[sz * sz - 1] = b;
        arr[sz * sz - sz] = c;
        arr[0] = d;
        return arr;

    }

    @Test
    public void printsCorrectOutput(){
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
    static Stream<int[][]> inputProvider() {
        int[][] t1 = {
                {0, 0, 1},
                {0, 0, 0},
                {1, 0, 0}
        };
        int[][] t2 = {
                {1, 0},
                {0, 1}
        };
        int[][] t3 = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 1},
                {3, 4, 5, 1, 2},
                {4, 5, 1, 2, 3},
                {5, 1, 2, 3, 4}
        };
        return Stream.of(
            t1, t2, t3
        );
    }
    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctRotateArrayMethod(int[][] arr) throws Throwable {
        int[] input = new int[arr.length * arr[0].length];
        for(int i = 0; i < arr.length; i ++){
            for(int j = 0; j < arr[0].length; j ++)
                input[i * arr[0].length + j] = arr[i][j];
        }
        int[] ans = answerFor(input);
        Clause[] c = new Clause[2 * arr.length * arr[0].length];
        for(int i = 0; i < 2 * arr.length * arr[0].length; i += 2){
            c[i] = new StringLiteral("" + ans[i / 2]);
            c[i + 1] = new NewLine();
        }
        Object[][] arguments = {
                {arr, int[][].class}
        };
        TestOption.incorrectStructureErrorMessage = "Your rotateArray method does not rotated the 2D array correctly.";
        MethodTest m = new MethodTest(Rotation.class, "rotateArray", arguments, c);

    }
}