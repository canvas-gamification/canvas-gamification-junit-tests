package arrays.referencing_array_and_its_elements.medium.q12;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.*;
import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest {
    // Java

    public static int n = 10;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = arrayToInput(generateRandomArray(-1000.0, 1000.0, n));
        return new Clause[]{
                new StringLiteral("Enter the price of " + n + " purchases:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The sum of purchases is "),
                new DoubleLiteral("ans"),
                new Optional(new StringLiteral("."))
        };
    }

    public void runMain() {
        SumPurchase.main(new String[0]);
    }

    static Stream<double[]> inputProvider() {
        return Stream.of(
                generateRandomArray(-100000000.0, 100000000.0, n),
                generateRandomArray(-100000000.0, 100000000.0, n),
                generateRandomArray(-100000000.0, 100000000.0, n),
                generateRandomArray(-100000000.0, 100000000.0, n),
                replicateArray(0.0, n),
                replicateArray(1.0, n)

        );
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void printsCorrectOutput(double[] a) {
        runWithInput(arrayToInput(a));
        assertEquals(sum(a), Double.parseDouble(getItemByName("ans")), 0.001);
    }
}
