package arrays.creating_arrays.hard.q3;

import global.BaseTest;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java

    private final static int size = 100;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray(-10000, 10000, size));
        return clauseBuilder();
    }

    public void runMain() {
        StoringInts.main(new String[0]);
    }

    static Stream<int[]> mainMethodInputProvider() {
        return Stream.of(
                ArrayUtil.generateRandomArray(-10000, 10000, size),
                ArrayUtil.generateRandomArray(-10000, 10000, size),
                ArrayUtil.generateRandomArray(-10000, 10000, size),
                ArrayUtil.generateRandomArray(-10000, 10000, size)
        );
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(int[] in) {
        runWithInput(ArrayUtil.arrayToInput(in));
        String m = "Your program does not print the correct value for the randomly generated index";
        for (int x = 0; x < size; x++) {
            assertEquals(in[Integer.parseInt(getItemByName("index" + x))], Integer.parseInt(getItemByName("num" + x)), m);
        }
    }

    public Clause[] clauseBuilder() {
        Clause[] c = new Clause[size * 5 + 3];

        c[0] = new StringLiteral("Enter " + size + " integers:");
        c[1] = new Optional(new StringLiteral(" "));
        c[2] = new NewLine();

        int count = 3;

        for (int x = 0; x < size; x++) {
            c[count++] = new StringLiteral("Number at index ");
            c[count++] = new RandomInteger(0, size, "index" + x);
            c[count++] = new StringLiteral(" is: ");
            c[count++] = new IntegerLiteral("num" + x);
            c[count++] = new NewLine();
        }

        return c;
    }
}
