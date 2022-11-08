package arrays.programs_involving_multidimensional_data.hard.q1;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
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
        TestOption.defaultInput = "3 2 4 32 4 2 12 32";
        return new Clause[]{
                new StringLiteral("Enter the number of rows:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter the number of columns:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain(){
        Sums.main(new String[0]);
    }

    static Stream<int[][]> mainMethodInputProvider(){
        return Stream.of(
                new int[][]{
                        {232, 43, 23, 43, 42, 43, 2},
                        {43, 8, 12, 321, 53, 5, 1},
                        {90, 43, 84, 1923, 48, 19, 7}
                }
                ,
                new int[][]{
                        {5},
                        {7}
                }
        );
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void correctMainMethodOutput(int[][] input) throws InvalidClauseException {
        String s = "";
        for(int x = 0; x < input.length; x++){
            s += ArrayUtil.arrayToInput(input[x]);
            s += " ";
        }
        runWithInput(input.length + " " + input[0].length + " " + s, clauseBuilder(input.length, input[0].length));

        int[] sums = new int[input.length];

        for(int x = 0; x < input.length; x++){
            for(int y =0; y < input[0].length; y++){
                sums[x] += input[x][y];
            }
        }

        for(int x = 0; x < input.length; x++){
            assertEquals(sums[x], Integer.parseInt(getItemByName(String.valueOf(x))), "Your program does not print the correct sum of rows.");
        }
    }

    public Clause[][] clauseBuilder(int rows, int cols){
        Clause[][] c = new Clause[1][(rows*cols*3) + (rows*2)];
        int count = 0;

        for(int x = 0; x < rows; x++){
            for(int y = 0; y < cols; y++){
                c[0][count++] = new StringLiteral("Enter the number for row " + (x+1) + " column " + (y+1) + ":");
                c[0][count++] = new Optional(new StringLiteral(" "));
                c[0][count++] = new NewLine();
            }
        }

        for(int x = 0; x < rows; x++){
            c[0][count++] = new IntegerLiteral(x);
            c[0][count++] = new StringLiteral(" ");
        }

        return c;
    }
}
