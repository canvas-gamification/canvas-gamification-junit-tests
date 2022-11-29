package arrays.referencing_array_and_its_elements.hard.q11;

import global.BaseTest;
import global.MethodTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.*;
import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest {
    // Java

    public static int n = 10;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = arrayToInput(generateRandomArray(-100.0, 100.0, n));
        return new Clause[]{
                new StringLiteral("Enter an array of " + n + " double values:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The maximum value of the array is: "),
                new DoubleLiteral("ans")
        };
    }

    public void runMain() {
        MaxFinder.main(new String[0]);
    }

    public static double max(double[] arr) {
        double ans = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > ans)
                ans = arr[i];
        }
        return ans;
    }

    static Stream<Arguments> mainInputProvider() {
        return Stream.of(
                Arguments.of(generateRandomArray(-1000.0, 1000.0, n)),
                Arguments.of(generateRandomArray(-1000.0, 1000.0, n)),
                Arguments.of(generateRandomArray(-1000.0, 1000.0, n)),
                Arguments.of(replicateArray(1.0, n))


        );
    }

    @ParameterizedTest
    @MethodSource("mainInputProvider")
    void printCorrectOutput(double[] input) {
        double ans = max(input);
        runWithInput(arrayToInput(input));
        assertEquals(ans, Double.parseDouble(getItemByName("ans")), 0.001, "Your program does not print the maximum value of the double array.");
    }


    static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(generateRandomArray(-1000.0, 1000.0, 10000)),
                Arguments.of(generateRandomArray(-1000.0, 1000.0, 10000)),
                Arguments.of(generateRandomArray(-1000.0, 1000.0, 10000)),
                Arguments.of(replicateArray(1.0, 10000))
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctFindLow(double[] input) throws Throwable {
        Object[][] arguments = {
                {input, double[].class},
        };
        MethodTest m = new MethodTest(MaxFinder.class, "findMax", arguments);
        m.setIncorrectMethodStructureErrorMessage("Your findMax method does not correctly show the maximum value of the double array");
        Object output = m.callMethod();
        assertEquals((double) output, max(input), 0.001);
    }

}
