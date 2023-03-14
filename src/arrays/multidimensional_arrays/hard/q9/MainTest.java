package arrays.multidimensional_arrays.hard.q9;

import global.BaseTest;
import global.MethodTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.generateRandomArray;

public class MainTest extends BaseTest {
    // Parsons

    public static final int[][][] nums = {{{1, 2}, {3, 4}, {5, 6}}, {{2, 1}, {4, 4}, {11, 0}}, {{12, 24}, {31, 44}, {51, 60}}};

    public Clause[] testSentence() {
        String st = "";
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                for (int k = 0; k < nums[i][j].length; k++)
                    st += nums[i][j][k] + " ";
            }
        }
        return new Clause[]{
                new StringLiteral(st),
        };
    }

    public void runMain() {
        ImAWholeDimensionAhead.main(new String[0]);
    }

    static Stream<int[][][]> inputProvider() {
        int[][][] test = new int[5][15][10];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 15; j++)
                test[i][j] = generateRandomArray(-1000000000, 1000000000, 10);
        }
        return Stream.of(
                nums,
                new int[][][]{{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}, {{9, 10}, {11, 12}}},
                test
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctImAWholeDimensionAheadMethod(int[][][] a) throws Throwable {
        TestOption.incorrectStructureErrorMessage = "Your imAWholeDimensionAhead method does not correctly print the elements of the 3D array.";
        String ans = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                for (int k = 0; k < a[i][j].length; k++)
                    ans += a[i][j][k] + " ";
            }
        }
        Clause[] methodSentence = new Clause[]{
                new StringLiteral(ans)
        };
        Object[][] arguments = {
                {a, int[][][].class}
        };
        MethodTest m = new MethodTest(ImAWholeDimensionAhead.class, "imAWholeDimensionAhead", arguments, methodSentence);
        m.callMethod();
    }
}
