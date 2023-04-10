package arrays.arrays_with_methods.hard.q13;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java

    static final int n = 10;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray(0, 10000, n));
        return new Clause[]{
                new StringLiteral("Enter an array of " + n + " integers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        ArrayngeOfPrimes.main(new String[0]);
    }

    static Stream<int[]> mainMethodInputProvider() {
        return Stream.of(
                ArrayUtil.generateAscendingArray(1, n),
                ArrayUtil.generateRandomArray(1, 10000, n),
                ArrayUtil.generateRandomArray(1, 10, n)
        );
    }

    static Stream<int[]> getPrimesInputProvider() {
        return Stream.of(
                ArrayUtil.generateAscendingArray(1, 100),
                ArrayUtil.generateRandomArray(1, 10000, 35),
                ArrayUtil.generateRandomArray(1, 10, 10000),
                ArrayUtil.generateRandomArray(2, 5, 1),
                ArrayUtil.generateRandomArray(2, 5, 2),
                ArrayUtil.generateAscendingArray(1, 250, 2),
                new int[]{5, 7, 5, 2},
                new int[]{1, 4, 6, 8, 9, 10, 12, 14, 21, 66, 12, 4},
                new int[]{15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                new int[]{3169, 1999, 4793, 5783, 7919, 6311, 672832, 733},
                new int[]{5, 53, 157, 173, 211, 257, 263, 3731367, 1511, 1747, 1753, 1907, 2287, 2417, 3637, 3733, 4013, 4409, 4457, 4597, 4657, 4691, 4993, 5107, 5113, 5393},
                new int[]{2, 5, 877, 27644437},
                new int[]{8269, 9242, 10267, 11718, 12097, 13260, 13669, 16653, 19441, 19929, 22447, 23427, 24571, 25117, 26228, 27361, 33391, 35317}
        );
    }

    @ParameterizedTest
    @MethodSource("getPrimesInputProvider")
    void correctGetPrimesMethod(int[] in) throws Throwable {
        int[] expected = solution(in);
        Object[][] arguments = {
                {in, int[].class}
        };
        MethodTest m = new MethodTest(ArrayngeOfPrimes.class, "getPrimes", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(expected, output, "Your getPrimes method does not correctly collect and return all prime numbers.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void correctMainMethodOutput(int[] in) throws InvalidClauseException {
        int[] ans = solution(in);
        Clause[][] c = new Clause[1][ans.length * 2];
        int count = 0;

        for (int x = 0; x < ans.length; x++) {
            c[0][count++] = new IntegerLiteral(ans[x]);
            c[0][count++] = new NewLine();
        }

        runWithInput(ArrayUtil.arrayToInput(in), c);
    }

    private static int[] solution(int[] arr) {
        int[] hold = new int[arr.length];
        int primeCount = 0;
        int count = 0;
        for (int x = 0; x < arr.length; x++) {
            int n = arr[x];
            int c = 0;
            for (int i = 1; i <= n; i++)
                if (n % i == 0)
                    c++;
            if (c == 2) {
                primeCount++;
                hold[count++] = n;
            }
        }

        int[] primes = new int[primeCount];
        System.arraycopy(hold, 0, primes, 0, primeCount);
        return primes;
    }
}
