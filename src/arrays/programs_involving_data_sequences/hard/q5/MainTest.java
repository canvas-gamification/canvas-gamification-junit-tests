package arrays.programs_involving_data_sequences.hard.q5;

import global.BaseTest;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    private static final int inputLength = 8;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = randomIntegerInput() + 4;
        return new Clause[]{
                new StringLiteral("Enter 8 numbers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter a number to search for:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new IntegerLiteral("index")
        };
    }

    public void runMain() {
        FindThatNumber.main(new String[0]);
    }

    private String randomIntegerInput(){
        Random r = new Random();
        return (r.nextInt(10) + " ").repeat(inputLength);
    }

    static Stream<Arguments> methodInputProvider(){
        return Stream.of(Arguments.of(new int[]{1, 4, 100, 11, -45, 7, -3, 0, 9, 4, -12, 0, 4}, 4, 12));
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctFindTheLastMethod(int[] arr, int search, int index) throws Throwable {
        int outputIndex = (int) MethodUtil.invokeIfMethodExists(FindThatNumber.class, "findTheLast",
                new Object[]{arr, search}, int[].class, int.class);
        assertEquals(index, outputIndex, "Your method does not find the last occurrence ofa number in an array.");
        String methodConsoleOutput = MethodUtil.getMethodOutput();
        assertEquals("", methodConsoleOutput, "Your method should not have any printed output.");
    }

    @Test
    void printsCorrectOutput(){
        String input = randomIntegerInput();
        runWithInput();
    }
}
