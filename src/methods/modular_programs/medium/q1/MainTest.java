package methods.modular_programs.medium.q1;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The sum of the absolute value of the variables is "),
                new IntegerLiteral("sum")
        };
    }

    public void runMain() {
        SumSum.main(new String[0]);
    }

    static Stream<Arguments> sumAbsoluteInputProvider() {
        return Stream.of(
                Arguments.of(new Object[]{-1, 5, 11, -5928, 0}, 5945),
                Arguments.of(new Object[]{2, 7, 193, 412, 3}, 617),
                Arguments.of(new Object[]{-11, -4, -539, -32, -235}, 821)
        );
    }

    @ParameterizedTest
    @MethodSource("sumAbsoluteInputProvider")
    void correctSumAbsoluteMethod(Object[] input, int sum) throws Throwable {
        Class<?>[] numInputs = new Class[input.length];
        Arrays.fill(numInputs, int.class);
        Object output = MethodUtil.invokeIfMethodExists(SumSum.class, "sumAbsolute", input, numInputs);
        CustomAssertions._assertEquals(sum, output, "Your sumAbsolute method does not correctly sum the absolute values of the variables.");
    }

    @Test
    void printsOutputCorrectly() {
        assertEquals(118, Integer.parseInt(getItemByName("sum")), "Your program does not correctly output the sum of the absolute values of the variables.");
    }
}
