package arrays.programs_involving_multidimensional_data.medium.q1;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons with distractors

    static final int size = 5;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray(1, 11, size * size * 2));
        return clauseBuilder();
    }

    public void runMain() {
        Identical.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        int[][] a1 = new int[size][size];
        int[][] b1 = new int[size][size];

        for (int x = 0; x < size; x++) {
            a1[x] = ArrayUtil.generateRandomArray(1, 11, size);
            b1[x] = ArrayUtil.generateRandomArray(1, 11, size);
        }

        int[][] a2 = new int[size][size];
        int[][] b2 = new int[size][size];

        for (int x = 0; x < size; x++) {
            a2[x] = ArrayUtil.generateRandomArray(10, 1001, size);
            b2[x] = ArrayUtil.generateRandomArray(10, 1001, size);
        }

        int[][] a3 = new int[size][size];
        int[][] b3 = new int[size][size];

        for (int x = 0; x < size; x++) {
            a3[x] = ArrayUtil.replicateArray(1, size);
            b3[x] = ArrayUtil.replicateArray(1, size);
        }

        int[][] a4 = new int[size][size];
        int[][] b4 = new int[size][size];

        for (int x = 0; x < size; x++) {
            a4[x] = ArrayUtil.generateRandomArray(1, 101, size);
            b4[x] = ArrayUtil.generateRandomArray(1, 101, size);
            for (int y = 0; y < size; y++) {
                a4[x][y] *= -1;
                b4[x][y] *= -1;
            }
        }

        int[][] a5 = new int[size][size];
        int[][] b5 = new int[size][size];

        for (int x = 0; x < size; x++) {
            a5[x] = ArrayUtil.generateAscendingArray(6, size);
            b5[x] = ArrayUtil.generateAscendingArray(6, size);
        }

        return Stream.of(
                Arguments.of(a1, b1),
                Arguments.of(a2, b2),
                Arguments.of(a3, b3),
                Arguments.of(a4, b4),
                Arguments.of(a5, b5)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctMainMethodOutput(int[][] a, int[][] b) throws InvalidClauseException {
        StringBuilder s = new StringBuilder();

        for (int x = 0; x < size; x++) {
            s.append(ArrayUtil.arrayToInput(a[x]));
        }
        s.append(" ");
        for (int x = 0; x < size; x++) {
            s.append(ArrayUtil.arrayToInput(b[x]));
        }

        TestOption.incorrectStructureErrorMessage = "Your program does not print out the correct number of repetitions of 'different'.";
        runWithInput(s.toString(), placeHolderClauseBuilder(a, b));
    }

    public Clause[] clauseBuilder() {
        Clause[] c = new Clause[size * 4 + 1];
        int count = 0;

        for (int x = 0; x < size; x++) {
            c[count++] = new StringLiteral("Enter " + size + " values for array a row " + x + ": ");
            c[count++] = new NewLine();
        }
        for (int x = 0; x < size; x++) {
            c[count++] = new StringLiteral("Enter " + size + " values for array b row " + x + ": ");
            c[count++] = new NewLine();
        }
        c[count] = new PlaceHolder();

        return c;
    }

    public Clause[][] placeHolderClauseBuilder(int[][] a, int[][] b) {
        int differences = 0;

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (a[x][y] != b[x][y])
                    differences++;
            }
        }

        Clause[][] c = new Clause[1][differences * 2];
        int count = 0;

        for (int x = 0; x < differences; x++) {
            c[0][count++] = new StringLiteral("different");
            c[0][count++] = new NewLine();
        }

        return c;
    }
}
