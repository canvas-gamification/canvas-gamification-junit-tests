package methods.method_overloading.medium.q1;

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

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The output of both sum methods is: "),
                new IntegerLiteral("sum1"),
                new StringLiteral(" and "),
                new IntegerLiteral("sum2")
        };
    }

    public void runMain() {
        OverloadSum.main(new String[0]);
    }

    static Stream<Arguments> sum2MethodInputProvider() {
        return Stream.of(
                Arguments.of(2, 4, 6),
                Arguments.of(798414, 447756, 1246170),
                Arguments.of(-486, 38, -448)
        );
    }

    static Stream<Arguments> sum3MethodInputProvider() {
        return Stream.of(
                Arguments.of(45, 7894, 0, 7939),
                Arguments.of(-11, 352, -754, -413)
        );
    }

    @ParameterizedTest
    @MethodSource("sum2MethodInputProvider")
    void correctTwoIntegerSumMethod(int x, int y, int sum) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(OverloadSum.class, "sum", new Object[]{x, y}, int.class, int.class);
        CustomAssertions._assertEquals(sum, output, "Your sum method does not correctly calculate the sum of two integers.");
    }

    @ParameterizedTest
    @MethodSource("sum3MethodInputProvider")
    void correctThreeIntegerSumMethod(int x, int y, int z, int sum) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(OverloadSum.class, "sum", new Object[]{x, y, z}, int.class, int.class, int.class);
        CustomAssertions._assertEquals(sum, output, "Your sum method does not correctly calculate the sum of three integers.");
    }

    @Test
    void printsOutputCorrectly() {
        assertEquals(50, Integer.parseInt(getItemByName("sum1")), "Your program does not correctly calculate and output the two integer sum.");
        assertEquals(66, Integer.parseInt(getItemByName("sum2")), "Your program does not correctly calculate and output the three integer sum.");
    }
}
