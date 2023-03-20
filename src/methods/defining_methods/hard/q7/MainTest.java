package methods.defining_methods.hard.q7;

import java.util.stream.Stream;

import global.MethodTest;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "366";

        return new Clause[]{
                new StringLiteral("Enter the number of days in this year:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder(),
        };
    }

    public void runMain() {
        CurrentYearMethod.main(new String[0]);
    }

    static Stream<Arguments> leapCheckerInputProvider() {
        return Stream.of(
                Arguments.of(366, true),
                Arguments.of(365, false),
                Arguments.of(34, false),
                Arguments.of(367, false),
                Arguments.of(1, false),
                Arguments.of(0, false),
                Arguments.of(-1, false),
                Arguments.of(-366, false));
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of(366, "This year is a leap year."),
                Arguments.of(365, "This year isn't a leap year."),
                Arguments.of(18, "This year isn't a leap year."),
                Arguments.of(367, "This year isn't a leap year."),
                Arguments.of(1, "This year isn't a leap year."),
                Arguments.of(0, "This year isn't a leap year."),
                Arguments.of(-5, "This year isn't a leap year."),
                Arguments.of(-366, "This year isn't a leap year."));
    }

    @ParameterizedTest
    @MethodSource("leapCheckerInputProvider")
    void correctLeapCheckerMethod(int numDays, boolean isLeapYear) throws Throwable {
        Object[][] arguments = {
                {numDays, int.class}
        };
        MethodTest m = new MethodTest(CurrentYearMethod.class, "leapChecker", arguments);
        Object output = m.callMethod();
        String errorMessage = "Your leapChecker() method does not correctly identify if the year is a leap year.";
        CustomAssertions._assertEquals(isLeapYear, output, errorMessage);
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsCorrectLeapYearMessage(int numDays, String isLeapYearStr) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print if the year is a leap year.";
        runWithInput(numDays + "", new Clause[]{
                new StringLiteral(isLeapYearStr)
        });
    }
}
