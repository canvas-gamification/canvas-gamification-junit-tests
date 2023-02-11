package arrays.referencing_array_and_its_elements.medium.q12;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.*;

public class MainTest extends BaseTest {
    // Java

    public static int n = 35;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = arrayToInput(generateRandomArray(-1000.0, 1000.0, n)) + " " + n;
        return new Clause[]{
                new StringLiteral("Enter the price of " + n + " purchases:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter an integer:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The sum of the first "),
                new IntegerLiteral("x"),
                new StringLiteral(" purchases is "),
                new DoubleLiteral("ans"),
                new Optional(new StringLiteral("."))
        };
    }

    public void runMain() {
        SumPurchase.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(generateRandomArray(-100000.0, 100000.0, n), n / 2),
                Arguments.of(generateRandomArray(-1000000.0, 1000000.0, n), 3),
                Arguments.of(generateRandomArray(-10000000.0, 10000000.0, n), n),
                Arguments.of(generateRandomArray(-100000000.0, 100000000.0, n), n - 1),
                Arguments.of(replicateArray(0.0, n), n),
                Arguments.of(replicateArray(1.0, n), n)

        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsCorrectOutput(double[] a, int x) {
        runWithInput(arrayToInput(a) + " " + x);
        double s = 0.0;
        for (int i = 0; i < x; i++)
            s += a[i];
        CustomAssertions._assertEquals(s, Double.parseDouble(getItemByName("ans")), 0.0001, "Your program does not calculate the correct sum of purchases.");
        CustomAssertions._assertEquals(x, Integer.parseInt(getItemByName("x")), "Your program does not print the sum of the required number of elements.");
    }
}
