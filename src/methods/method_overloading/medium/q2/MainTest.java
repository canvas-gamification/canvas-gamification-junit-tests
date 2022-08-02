package methods.method_overloading.medium.q2;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
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
                new StringLiteral("The greater value is: "),
                new DoubleLiteral("max")
        };
    }

    public void runMain() {
        LargerOfVars.main(new String[0]);
    }

    static Stream<Arguments> maxIntDoubleInputProvider() {
        return Stream.of(
                Arguments.of(3, 7, 7.0),
                Arguments.of(9787, 3532.8465, 9787.0),
                Arguments.of(-3522, 0.0, 0.0),
                Arguments.of(89, 458.4698, 458.4698)
        );
    }

    static Stream<Arguments> maxDoubleIntInputProvider() {
        return Stream.of(
                Arguments.of(-37.584, -37, -37.0),
                Arguments.of(518.32458, 486, 518.32458),
                Arguments.of(85358.2154, 85266185, 85266185.0)
        );
    }

    @ParameterizedTest
    @MethodSource("maxIntDoubleInputProvider")
    void correctlyOverloadedMaxMethod1(int x, double y, double max) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(LargerOfVars.class, "max", new Object[]{x, y}, int.class, double.class);
        CustomAssertions._assertEquals(max, output, 0.000000000001, "Your max method does not correctly calculate the maximum of an integer and a double.");
        String methodConsoleOutput = MethodUtil.getMethodOutput();
        assertEquals("", methodConsoleOutput, "Your max method should not have any console output.");
    }

    @ParameterizedTest
    @MethodSource("maxDoubleIntInputProvider")
    void correctlyOverloadedMaxMethod2(double x, int y, double max) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(LargerOfVars.class, "max", new Object[]{x, y}, double.class, int.class);
        CustomAssertions._assertEquals(max, output, 0.000000000001, "Your method does not correctly calculate the maximum of a double and an integer.");
        String methodConsoleOutput = MethodUtil.getMethodOutput();
        assertEquals("", methodConsoleOutput, "Your max method should not have any console output.");
    }

    @Test
    void printsCorrectOutput() {
        assertEquals(5.5, Double.parseDouble(getItemByName("max")), "Your program does not correctly identify and print which value is the maximum.");
    }
}
