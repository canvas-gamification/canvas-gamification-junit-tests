package arrays.multidimensional_arrays.hard.q2;

import global.BaseTest;
import global.tools.TestOption;
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
                new StringLiteral("count of even numbers in array = "),
                new IntegerLiteral("even")
        };
    }

    public void runMain(){
        SimpleDisplay.main(new String[0]);
    }

    static Stream<Arguments> mainMethodInputProvider(){
        return Stream.of(
                Arguments.of(0, 0, new int[]{}, 0),
                Arguments.of(1, 0, new int[]{}, 0),
                Arguments.of(0, 1, new int[]{}, 0),
                Arguments.of(2, 3, new int[]{-3, 1, 7, 2, 1, 19}, 1),
                Arguments.of(5, 5, new int[]{5, 12, -43, -5, 12, 43, 5, 7, 76, 854, -7542, 75, 98, 2842, 53912, 24, 532,
                        65, 542, -523, 75, -753, 563, 4, 32}, 13),
                Arguments.of(10, 2, new int[]{44, 26, 12, 780, 56, 8024, 477632, 382, 78, 8, 2, 12, 432, 56, 370, 790,
                12, 42, 612, 964}, 20),
                Arguments.of(3, 8, new int[]{131, 421, 6427, 85, 7, 1, 81, 839, 2581, 294267, 81623, 91, 19, 85, 901, 61,
                873245, 867, 831, 2945763, 53, 71, 8365, 641}, 0)
        );
    }

    static Stream<Arguments> numsInputProvider(){
        return Stream.of(
                Arguments.of(new int[][]{}, 0),
                Arguments.of(new int[][]{}, 0),
                Arguments.of(new int[][]{}, 0),
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
    void correctMainMethodOutput(int row, int col, int[] nums, int evens){
        StringBuilder s = new StringBuilder(row + " " + col + " ");

        int count = 0;

        for(int x = 0; x < row; x++){
            for(int y = 0; y < col; y++){
                s.append(nums[count++]);
                s.append(" ");
            }
        }

        runWithInput(s.toString());

        assertEquals(evens, Integer.parseInt(getItemByName("even")), "Your program does not display the correct amount of even numbers in the array.");
    }
}
