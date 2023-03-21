package arrays.multidimensional_arrays.hard.q2;

import global.BaseTest;
import global.MethodTest;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "3 3 1 2 3 4 5 6 7 8 9";
        return new Clause[]{
                new StringLiteral("Enter the number of rows:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter the number of columns:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter the values for the array:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The number of even integers in array is: "),
                new IntegerLiteral("even")
        };
    }

    public void runMain() {
        SimpleDisplay.main(new String[0]);
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of(2, 3, new int[]{-3, 1, 7, 2, 1, 19}, 1),
                Arguments.of(5, 5, new int[]{5, 12, -43, -5, 12, 43, 5, 7, 76, 854, -7542, 75, 98, 2842, 53912, 24, 532,
                        65, 542, -523, 75, -753, 563, 4, 32}, 13),
                Arguments.of(10, 2, new int[]{44, 26, 12, 780, 56, 8024, 477632, 382, 78, 8, 2, 12, 432, 56, 370, 790,
                        12, 42, 612, 964}, 20),
                Arguments.of(3, 8, new int[]{131, 421, 6427, 85, 7, 1, 81, 839, 2581, 294267, 81623, 91, 19, 85, 901, 61,
                        873245, 867, 831, 2945763, 53, 71, 8365, 641}, 0)
        );
    }

    static Stream<Arguments> numsInputProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{-3, 1, 7}, {2, 1, 19}}, 1),
                Arguments.of(new int[][]{{5, 12, -43, -5, 12}, {43, 5, 7, 76, 854}, {-7542, 75, 98, 2842, 53912}, {24,
                        532, 65, 542, -523}, {75, -753, 563, 4, 32}}, 13),
                Arguments.of(new int[][]{{44, 26, 12, 780, 56, 8024, 477632, 382, 78, 8}, {2, 12, 432, 56, 370, 790,
                        12, 42, 612, 964}}, 20),
                Arguments.of(new int[][]{{131, 421, 6427}, {85, 7, 1}, {81, 839, 2581}, {294267, 81623, 91}, {19, 85,
                        901}, {61, 873245, 867}, {831, 2945763, 53}, {71, 8365, 641}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void correctMainMethodOutput(int row, int col, int[] nums, int evens) {

        runWithInput(row + " " + col + " " + ArrayUtil.arrayToInput(nums));

        assertEquals(evens, Integer.parseInt(getItemByName("even")), "Your program does not correctly count and display the number of even integers in the array.");
    }

    @ParameterizedTest
    @MethodSource("numsInputProvider")
    void correctNumsMethod(int[][] arr, int evens) throws Throwable {
        Clause[] methodSentence = new Clause[]{
                new StringLiteral("The number of even integers in array is: "),
                new IntegerLiteral("even")
        };
        Object[][] arguments = {
                {arr, int[][].class}
        };
        MethodTest m = new MethodTest(SimpleDisplay.class, "even", arguments, methodSentence);
        m.setIncorrectMethodStructureErrorMessage("Your even method does not print the correct output.");
        m.callMethod();

        assertEquals(evens, Integer.parseInt(m.getMethodItemByName("even")), "Your even method does not correctly count and display number of even integers present in the input array.");
    }
}
