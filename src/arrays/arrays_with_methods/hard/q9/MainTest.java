package arrays.arrays_with_methods.hard.q9;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.ArrayUtil;
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
import static org.junit.jupiter.api.Assertions.assertNull;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "4 23 87 17 96";
        return new Clause[]{
                new StringLiteral("Enter 5 integers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new IntegerLiteral("first"),
                new NewLine(),
                new IntegerLiteral("second"),
                new NewLine(),
                new IntegerLiteral("third"),
                new NewLine(),
                new IntegerLiteral("fourth"),
                new NewLine(),
                new IntegerLiteral("fifth")
        };
    }

    public void runMain() {
        ArrayofDigits.main(new String[0]);
    }

    static Stream<int[]> powerNInputProvider() {
        return Stream.of(
                new int[]{0, 0, 0, 0, 0},
                new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1},
                new int[]{1, 2, 3, 4, 5},
                new int[]{6, 7, 8, 9, 10},
                new int[]{2128, 73, 29, 18236, 273},
                new int[]{-5, -23, -78, -1542, -18},
                new int[]{-46, 2, 98, -37413, -8701},
                ArrayUtil.generateRandomArray(-1000, 1000, 500),
                ArrayUtil.generateRandomArray(-300, -1, 550),
                ArrayUtil.generateAscendingArray(-100, 200)
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of("6 78 32 19 5", 36, 6084, 1024, 361, 25),
                Arguments.of("-25 638 24624 483 -1", 625, 407044, 606341376, 233289, 1),
                Arguments.of("2 2 17 649 34827", 4, 4, 289, 421201, 1212919929)
        );
    }

    public static int[] ans(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            result[i] = arr[i]*arr[i];
        return result;
    }

    @ParameterizedTest
    @MethodSource("powerNInputProvider")
    void correctPowerNMethod(int[] given) throws Throwable {
        int[] expected = ans(given);
        Object[][] arguments = {
                {given, int[].class}
        };
        MethodTest m = new MethodTest(ArrayofDigits.class, "powerN", arguments);
        Object output = m.callMethod();
        assertNull(output, "Your powerN does not have the correct return type.");
        CustomAssertions._assertArrayEquals(expected, given, "Your powerN method does not square the values in the input array.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void correctMainMethodOutput(String in, int one, int two, int three, int four, int five) {
        runWithInput(in);
        assertEquals(one, Integer.parseInt(getItemByName("first")), "Your program does not correctly square and print the array elements.");
        assertEquals(two, Integer.parseInt(getItemByName("second")), "Your program does not square the first number in the array.");
        assertEquals(three, Integer.parseInt(getItemByName("third")), "Your program does not square the first number in the array.");
        assertEquals(four, Integer.parseInt(getItemByName("fourth")), "Your program does not square the first number in the array.");
        assertEquals(five, Integer.parseInt(getItemByName("fifth")), "Your program does not square the first number in the array.");
    }
}
