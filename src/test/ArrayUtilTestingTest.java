package test;

import global.BaseTest;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayUtilTestingTest extends BaseTest {
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = ArrayUtil.intArrayToInput(ArrayUtil.generateRandomIntArray(-5, 5, 10));
        return new Clause[]{
                new StringLiteral("Enter 10 integers: "),
                new NewLine(),
                new StringLiteral("The sum of your array is: "),
                new IntegerLiteral("sum")
        };
    }

    public void runMain() {
        ArrayUtilTesting.main(new String[0]);
    }

    static Stream<int[]> inputProvider() {
        return Stream.of(
                ArrayUtil.generateRandomIntArray(-5, 5, 10),
                ArrayUtil.generateRandomIntArray(-50, -45, 10),
                ArrayUtil.generateRandomIntArray(39, 40, 10),
                ArrayUtil.generateRandomIntArray(-100, 100, 10),
                ArrayUtil.generateRandomIntArray(0, 10, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctSumMethod(int[] input) {
        runWithInput(ArrayUtil.intArrayToInput(input));
        assertEquals(ArrayUtil.sum(input), Integer.parseInt(getItemByName("sum")), "Your sum method does not correctly calculate the sum of the integer array.");
    }
}
