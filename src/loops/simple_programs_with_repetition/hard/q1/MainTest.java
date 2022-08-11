package loops.simple_programs_with_repetition.hard.q1;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "8208";
        return new Clause[]{
                new StringLiteral("Enter a number:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder(),
                new PlaceHolder(),
        };
    }

    public void runMain() {
        ArmsAreStrong.main(new String[0]);
    }

    static Stream<Integer> inputProviderArmstrongNumbers() {
        return Stream.of(1, 371, 8208, 9, 54748, 9800817, 88593477, 146511208, 0);
    }

    static Stream<Integer> inputProviderNonArmstrongNumbers() {
        return Stream.of(56, 8347, 83462, 923856, 64229649);
    }

    @ParameterizedTest
    @MethodSource("inputProviderArmstrongNumbers")
    void identifiesArmstrongNumbersCorrectly(int number) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify Armstrong Numbers.";
        runWithInput(String.valueOf(number), new Clause[]{
                new IntegerLiteral(number, "number"),
                new StringLiteral(" is an Armstrong Number!")
        });
    }

    @ParameterizedTest
    @MethodSource("inputProviderNonArmstrongNumbers")
    void identifiesNonArmstrongNumbersCorrectly(int number) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify numbers which are not Armstrong Numbers.";
        runWithInput(String.valueOf(number), new Clause[]{
                new IntegerLiteral(number, "number"),
                new StringLiteral(" is NOT an Armstrong Number!")
        });
    }
}
