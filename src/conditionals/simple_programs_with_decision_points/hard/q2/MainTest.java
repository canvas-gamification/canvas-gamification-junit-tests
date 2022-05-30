package conditionals.simple_programs_with_decision_points.hard.q2;

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
    // Parsons with distractors
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "2022 true";
        return new Clause[]{
                new StringLiteral("Enter a year:"),
                new NewLine(),
                new StringLiteral("Is it AD or BC\\? \\(Enter true for AD and false for BC\\)"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        HistoricMoment.main(new String[0]);
    }

    public static Stream<Arguments> inputProviderAD() {
        return Stream.of(Arguments.of(2022, true, 2021), Arguments.of(5, true, 4), Arguments.of(1, true, 0));
    }

    public static Stream<Arguments> inputProviderBC() {
        return Stream.of(Arguments.of(2022, false, 2023), Arguments.of(1, false, 2), Arguments.of(257, false, 258));
    }

    @ParameterizedTest
    @MethodSource("inputProviderAD")
    public void printsADMinusOneYearCorrectly(int year, boolean isAD, int yearMinus1) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the AD year minus one.";
        runWithInput(year + " " + isAD, new Clause[]{
                new StringLiteral(year + " AD - 1 = " + yearMinus1 + " AD")
        });
    }

    @ParameterizedTest
    @MethodSource("inputProviderBC")
    public void printsBCMinusOneYearCorrectly(int year, boolean isAD, int yearMinus1) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the BC year minus one.";
        runWithInput(year + " " + isAD, new Clause[]{
                new StringLiteral(year + " BC - 1 = " + yearMinus1 + " BC")
        });
    }

}
