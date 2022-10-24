package arrays.programs_involving_data_sequences.medium.q6;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new IntegerLiteral(2),
                new NewLine(),
                new IntegerLiteral(6),
                new NewLine(),
                new IntegerLiteral(10),
                new NewLine(),
                new IntegerLiteral(14),
                new NewLine(),
                new IntegerLiteral(18),
                new NewLine(),
                new IntegerLiteral(22),
                new NewLine(),
                new IntegerLiteral(44),
                new NewLine(),
                new IntegerLiteral(12)
        };
    }

    public void runMain(){
        MultiThing.main(new String[0]);
    }

    static Stream<int[]> multiplierInputProvider(){
        return Stream.of(
                ArrayUtil.generateRandomArray(0, 100, 20),
                ArrayUtil.generateRandomArray(-30, -1, 10),
                ArrayUtil.generateRandomArray(-60, 60, 25),
                ArrayUtil.generateRandomArray(0, 40, 250),
                ArrayUtil.generateRandomArray(500, 2000, 25),
                ArrayUtil.generateRandomArray(1, 10, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("multiplierInputProvider")
    void correctMultiplierInputProvider(int[] arr) throws Throwable {
        int[] expected = Arrays.copyOf(arr, arr.length);

        Object[][] arguments = {
                {arr, int[].class}
        };
        MethodTest m = new MethodTest(MultiThing.class, "multiplier", arguments);

        Object output = m.callMethod();

        CustomAssertions._assertArrayEquals(arrayAnswer(expected), output, "Your multiplier method does not correctly alter the given array.");

    }


    public static int[] arrayAnswer(int [] input)
    {
        for (int i = 0; i < input.length; i++)
        {
            if (input[i]%2 == 0)
                input[i] = input[i] / 2;
            else
                input[i] = input[i]*2;
        }

        return input;
    }
}
