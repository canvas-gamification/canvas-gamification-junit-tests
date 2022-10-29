package methods.modular_programs.medium.q10;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "18 30";
        return new Clause[]{
                new StringLiteral("Enter two integers: "),
                new NewLine(),
                new StringLiteral("The greatest common factor of "),
                new IntegerLiteral("firstNum"),
                new StringLiteral(" and "),
                new IntegerLiteral("secondNum"),
                new StringLiteral(" is "),
                new IntegerLiteral("ans"),
                new StringLiteral(".")
        };
    }

    public void runMain() {
        GCDCalculator.main(new String[0]);
    }

    static Stream<Arguments> mainInputProvider() {
        return Stream.of(
                Arguments.of("18", "30", "6"),
                Arguments.of("30", "18", "6"),
                Arguments.of("99999", "9", "9"),
                Arguments.of("2", "1", "1"),
                Arguments.of("29", "7", "1"),
                Arguments.of("5", "5", "5"),
                Arguments.of("12", "54", "6"),
                Arguments.of("0", "1", "1"),
                Arguments.of("0", "7", "7"),
                Arguments.of("1", "0", "1")
        );
    }

    @ParameterizedTest
    @MethodSource("mainInputProvider")
    void testForMainMethod(String s1, String s2, String exAns) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program did not display the correct structure";
        runWithInput(s1 + " " + s2);
        assertEquals(getItemByName("ans"), exAns, "Your program does not display the correct answer");
    }

    static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(18, 30, 6),
                Arguments.of(30, 18, 6),
                Arguments.of(99999, 9, 9),
                Arguments.of(2, 1, 1),
                Arguments.of(29, 7, 1),
                Arguments.of(5, 5, 5),
                Arguments.of(12, 54, 6),
                Arguments.of(0, 1, 1),
                Arguments.of(0, 7, 7),
                Arguments.of(1, 0, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void testForFindGCDMethod(int first, int second, int gcd) throws Throwable {
        Object[][] arguments = {
                {first, int.class},
                {second, int.class}
        };
        MethodTest m = new MethodTest(GCDCalculator.class, "findGCD", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(gcd, output,
                "Your findGCD method does not correctly return the gcd of the two input numbers.");
    }
}
