package arrays.referencing_array_and_its_elements.hard.q8;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java

    public static int n = 10;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = arrayToInput(generateAscendingArray(1, n));
        return new Clause[]{
                new StringLiteral("Enter " + n + " integers in ascending order:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The lowest missing number is: "),
                new IntegerLiteral("ans")
        };
    }

    public void runMain() {
        WhichOneIsNext.main(new String[0]);
    }

    public static int miss(int[] arr) {
        int ans = -1;
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] != (arr[i + 1] - 1)) {
                ans = arr[i] + 1;
                break;
            }
        return ans;
    }

    static Stream<int[]> mainInputProvider() {
        return Stream.of(
                merge(generateAscendingArray(1, n / 2), generateAscendingArray(n / 2 + 2, n - n / 2)),
                merge(generateAscendingArray(1, 2), generateAscendingArray(4, n - 2)),
                generateAscendingArray(1, n),
                merge(generateAscendingArray(-n / 2, n / 2), generateAscendingArray(1, n - n / 2)),
                merge(generateAscendingArray(1, n - 1), generateAscendingArray(n + 1, 1)),
                merge(generateAscendingArray(1, 1), generateAscendingArray(3, n - 1)),
                generateAscendingArray(-n, n)
        );
    }

    @ParameterizedTest
    @MethodSource("mainInputProvider")
    void printsCorrectOutput(int[] input) {
        int ans = miss(input);
        runWithInput(arrayToInput(input));
        assertEquals(ans, Integer.parseInt(getItemByName("ans")), "Your program does not print the lowest missing number correctly.");
    }


    static Stream<int[]> methodInputProvider() {
        return Stream.of(
                merge(generateAscendingArray(1, 10000), generateAscendingArray(10002, 10000)),
                merge(generateAscendingArray(1, 10000), generateAscendingArray(10002, 1)),
                merge(generateAscendingArray(1, 1), generateAscendingArray(3, 10000)),
                merge(generateAscendingArray(-10000, 40000), generateAscendingArray(40002, 10000)),
                generateAscendingArray(-324234, 10000),
                merge(generateAscendingArray(-1000000000, 10000), generateAscendingArray(1000000000, 10000)),
                new int[]{1, 3, 4, 5, 6, 7},
                new int[]{1, 2, 3, 4, 5, 6, 7, 9},
                new int[]{1, 3},
                new int[]{1}
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctMissingNoMethod(int[] input) throws Throwable {
        Object[][] arguments = {
                {input, int[].class},
        };
        MethodTest m = new MethodTest(WhichOneIsNext.class, "missingNo", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(miss(input), output, "Your missingNo method does not correctly show the first missing number in the ascending array.");
    }

}
