package methods.modular_programs.medium.q1;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
                Arguments.of(new int[]{-1, 5, 11, -5928, 0}, 5945),
                Arguments.of(new int[]{2, 7, 193, 412, 3}, 617),
                Arguments.of(new int[]{-11, -4, -539, -32, -235}, 821)
        );
    }

    @ParameterizedTest
    @MethodSource("sumAbsoluteInputProvider")
    void correctSumAbsoluteMethod(int[] input, int sum) throws Throwable {
        Object[][] arguments = {
                {input[0], int.class},
                {input[1], int.class},
                {input[2], int.class},
                {input[3], int.class},
                {input[4], int.class}
        };
        MethodTest m = new MethodTest(SumSum.class, "sumAbsolute", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(sum, output, "Your sumAbsolute method does not correctly sum the absolute values of the variables.");
    }

    @Test
    void printsOutputCorrectly() {
        assertEquals(118, Integer.parseInt(getItemByName("sum")), "Your program does not correctly output the sum of the absolute values of the variables.");
    }
}
