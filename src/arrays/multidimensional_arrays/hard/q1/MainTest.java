package arrays.multidimensional_arrays.hard.q1;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
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
    // Parsons

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "3 2 6 12 3 192 65 1";
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

    public void runMain() {
        AscendDimensions.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(2, 3),
                Arguments.of(4, 4),
                Arguments.of(8, 11),
                Arguments.of(56, 2),
                Arguments.of(41, 13)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsCorrectOutput(int rows, int columns) throws InvalidClauseException {
        int[][] nums = arrayBuilder(rows, columns);
        StringBuilder s = new StringBuilder(rows + " " + columns + " ");

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                s.append(nums[x][y]);
                s.append(" ");
            }
        }

        runWithInput(s.toString(), clauseBuilder(rows, columns));

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                assertEquals(nums[x][y], Integer.parseInt(getItemByName("row" + x + "col" + y)), "The number on row " + x + " column " + y + " is incorrect.");
            }
        }
    }

    public static int[][] arrayBuilder(int rows, int columns) {
        int[][] arr = new int[rows][columns];

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                arr[x][y] = (int) (Math.random() * 1000);
            }
        }

        return arr;
    }

    public static Clause[][] clauseBuilder(int rows, int columns) {
        //first bracket is for collecting the inputs. Second bracket is for printing array. Third is for new lines after each printed row.
        Clause[][] c = new Clause[1][(rows * columns * 3) + (rows * columns * 2) + (rows)];

        int count = 0;

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                c[0][count++] = new StringLiteral("Enter the number to store at row " + (x + 1) + ", column " + (y + 1) + ":");
                c[0][count++] = new Optional(new StringLiteral(" "));
                c[0][count++] = new NewLine();
            }
        }

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                c[0][count++] = new IntegerLiteral("row" + x + "col" + y);
                c[0][count++] = new StringLiteral(" ");
            }
            c[0][count++] = new NewLine();
        }

        return c;
    }
}
