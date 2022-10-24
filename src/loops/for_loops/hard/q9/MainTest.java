package loops.for_loops.hard.q9;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "67 9";
        return new Clause[]{
                new StringLiteral("Enter two integers: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        CommonDivisors.main(new String[0]);
    }

    static Stream<Arguments> TrueInputProvider() {
        return Stream.of(
                Arguments.of("10", "4"),
                Arguments.of("6", "3"),
                Arguments.of("150", "75"),
                Arguments.of("9", "999999"),
                Arguments.of("99999", "9"));
    }

    @ParameterizedTest
    @MethodSource("TrueInputProvider")
    void testWithTrueInput(String s1, String s2) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program did not display the correct answer";
        runWithInput(s1 + " " + s2, new Clause[]{
                new StringLiteral("true")});
    }

    static Stream<Arguments> FalseInputProvider() {
        return Stream.of(
                Arguments.of("10", "3"),
                Arguments.of("131", "15"),
                Arguments.of("21", "2"),
                Arguments.of("1", "2"),
                Arguments.of("7", "99999"),
                Arguments.of("99999", "7"));
    }

    @ParameterizedTest
    @MethodSource("FalseInputProvider")
    void testWithFalseInput(String s1, String s2) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program did not display the correct answer";
        runWithInput(s1 + " " + s2, new Clause[]{
                new StringLiteral("false")});
    }
}
