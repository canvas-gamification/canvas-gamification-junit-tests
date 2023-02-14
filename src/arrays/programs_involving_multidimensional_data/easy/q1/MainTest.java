package arrays.programs_involving_multidimensional_data.easy.q1;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.*;

public class MainTest extends BaseTest {
    //Parsons

    public static int n = 4;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = arrayToInput(generateRandomArray(1, 10, n * n));
        return new Clause[]{
                new StringLiteral("Enter a " + n + " by " + n + " multidimensional array in " + n + " lines:"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        AllSameSum.main(new String[0]);
    }

    boolean answerFor(int[][] a) {
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[i] += a[i][j];
            }
        }
        for (int i = 1; i < n; i++) {
            if (sum[i] != sum[i - 1])
                return false;
        }
        return true;
    }

    static Stream<int[][]> inputProvider() {
        int[][] t1 = new int[n][n];
        for (int i = 0; i < n; i++)
            t1[i] = replicateArray(1, n);
        int[][] t2 = new int[n][n];
        for (int i = 0; i < n; i++)
            t2[i] = generateRandomArray(1, 100, n);
        int[][] t3 = new int[n][n];
        for (int i = 0; i < n; i++)
            t3[i] = generateRandomArray(1, 100, n);
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += t3[i][j];
            }
            t3[i][0] += 1000 - sum;
        }
        int[][] t4 = new int[n][n];
        for (int i = 0; i < n; i++)
            t4[i] = generateRandomArray(1, 100, n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                t4[i][j] *= -1;
            }
        }
        return Stream.of(
                t1, t2, t3, t4
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsCorrectOutput(int[][] a) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify if the sum of the rows are all equal.";
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < n; i++)
            input.append(arrayToInput(a[i])).append("\n");
        runWithInput(input.toString(), new Clause[]{
                new StringLiteral("" + answerFor(a))
        });
    }
}
