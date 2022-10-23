package arrays.creating_arrays.hard.q2;

import global.BaseTest;
import global.tools.CustomAssertions;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "39 67 123 5 21";
        return new Clause[]{
                new StringLiteral("Enter a number to add to the array:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter a number to add to the array:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter a number to add to the array:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter a number to add to the array:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter a number to add to the array:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new IntegerLiteral("one"),
                new NewLine(),
                new IntegerLiteral("two"),
                new NewLine(),
                new IntegerLiteral("three"),
                new NewLine(),
                new IntegerLiteral("four"),
                new NewLine(),
                new IntegerLiteral("five")
        };
    }

    public void runMain() {
        RevdArray.main(new String[0]);
    }

    static Stream<Arguments> reverseInputProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(1000, 1),
                Arguments.of(24, 42),
                Arguments.of(3109, 9013),
                Arguments.of(9, 9),
                Arguments.of(73821, 12837),
                Arguments.of(73, 37)
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of("0 55 64 13 7356", 0, 55, 46, 31, 6537),
                Arguments.of("319 404 257 123 666", 913, 404, 752, 321, 666),
                Arguments.of("10000 43 7 8273 4372", 1, 34, 7, 3728, 2734)
        );
    }

    @ParameterizedTest
    @MethodSource("reverseInputProvider")
    void correctReverseMethod(int in, int ans) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(RevdArray.class, "reverse", new Object[]{in}, int.class);
        CustomAssertions._assertEquals(ans, output, "Your reverse method does not correctly reverse the given number.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, int one, int two, int three, int four, int five) {
        runWithInput(in);
        assertEquals(String.valueOf(one), getItemByName("one"), "Your program does not correctly reverse the first number");
        assertEquals(String.valueOf(two), getItemByName("two"), "Your program does not correctly reverse the second number");
        assertEquals(String.valueOf(three), getItemByName("three"), "Your program does not correctly reverse the third number");
        assertEquals(String.valueOf(four), getItemByName("four"), "Your program does not correctly reverse the fourth number");
        assertEquals(String.valueOf(five), getItemByName("five"), "Your program does not correctly reverse the fifth number");
    }
}
