package arrays.programs_involving_data_sequences.hard.q1;

import global.BaseTest;

import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "14 15 45 45 45 16 18 19 49 33 0 12 100 45";
        return new Clause[]{
                new StringLiteral("Please enter 14 numbers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The number of numbers below 45 is: "),
                new IntegerLiteral("below"),
                new NewLine(),
                new StringLiteral("The number of numbers equal to 45 is: "),
                new IntegerLiteral("equal"),
                new NewLine(),
                new StringLiteral("The number of numbers above 45 is: "),
                new IntegerLiteral("above")
        };
    }

    public void runMain() {
        CountArray.main(new String[0]);
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(Arguments.of("1 14 45 46 44 0 100 87 1 11 14 77 45 9", 8, 2, 4),
                Arguments.of("0 0 0 45 45 45 0 0 0 0 0 45 45 1", 9, 5, 0));
    }

    static Stream<Arguments> countThisInputProvider() {
        return Stream.of(Arguments.of(new int[]{45, 2, 44, 46, 18, 29, 78, 87, 46, 1, 0, 100, 45, 3}, 45, new int[]{7, 2, 5}),
                Arguments.of(new int[]{45, 68, 0, 69, 88, 56, 12, 59, 100, 45, 91, 2, 4, 70}, 69, new int[]{9, 1, 4}));
    }

    @ParameterizedTest
    @MethodSource("countThisInputProvider")
    void correctCountThisPleaseMethod(int[] input, int pivot, int[] result) throws Throwable {
        int[] output = (int[]) MethodUtil.invokeIfMethodExists(CountArray.class, "countThisPlease",
                new Object[]{input, pivot}, int[].class, int.class);
        assertArrayEquals(result, output, "Your method does not correctly count the all the number below, equal to, and above the pivot.");
        String consoleOutput = MethodUtil.getMethodOutput();
        assertEquals("", consoleOutput, "Your method should not have console output.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printCorrectOutput(String input, int below, int equal, int above) {
        runWithInput(input);
        assertEquals(Integer.parseInt(getItemByName("below")), below, "Your output for the numbers below the pivot is incorrect.");
        assertEquals(Integer.parseInt(getItemByName("equal")), equal, "Your output for the numbers equal to the pivot is incorrect.");
        assertEquals(Integer.parseInt(getItemByName("above")), above, "Your output for the numbers above the pivot is incorrect.");
    }
}
