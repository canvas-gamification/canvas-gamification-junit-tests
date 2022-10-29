package arrays.creating_arrays.hard.q3;

import global.BaseTest;
import global.tools.TestOption;
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
        TestOption.defaultInput = "34 1 5432 765 -12";
        return new Clause[]{
                new StringLiteral("Enter 5 integers:"),
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
        StoringInts.main(new String[0]);
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of("25 32 102 7362 4738", 25, 32, 102, 7362, 4738),
                Arguments.of("-45 -217 -2 -93 -12963", -45, -217, -2, -93, -12963),
                Arguments.of("0 7 12 1 5", 0, 7, 12, 1, 5),
                Arguments.of("743289 43824 73219 463 382787", 743289, 43824, 73219, 463, 382787)
        );
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, int one, int two, int three, int four, int five) {
        runWithInput(in);
        assertEquals(one, Integer.parseInt(getItemByName("one")), "Your program does not print the first input value");
        assertEquals(two, Integer.parseInt(getItemByName("two")), "Your program does not print the second input value");
        assertEquals(three, Integer.parseInt(getItemByName("three")), "Your program does not print the third input value");
        assertEquals(four, Integer.parseInt(getItemByName("four")), "Your program does not print the fourth input value");
        assertEquals(five, Integer.parseInt(getItemByName("five")), "Your program does not print the fifth input value");
    }
}
