package methods.using_methods.hard.q5;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
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
        TestOption.defaultInput = "2";
        return new Clause[]{
                new StringLiteral("Please enter what year you are in university:"),
                new NewLine(),
                new StringLiteral("Your designation is a "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        Standing.main(new String[0]);
    }

    static Stream<Arguments> designationCalcInputProvider() {
        return Stream.of(Arguments.of(1, "freshmen"), Arguments.of(2, "sophomore"), Arguments.of(3, "junior"), Arguments.of(4, "senior"), Arguments.of(5, "senior"), Arguments.of(10, "senior"), Arguments.of(-1, "unknown year"), Arguments.of(-23, "unknown year"));
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(Arguments.of("1", "freshmen"), Arguments.of("2", "sophomore"), Arguments.of("3", "junior"), Arguments.of("4", "senior"), Arguments.of("-5", "unknown year"));
    }

    @ParameterizedTest
    @MethodSource("designationCalcInputProvider")
    void correctDesignationCalcMethod(int in, String year) throws Throwable {
        Object[][] arguments = {
                {in, int.class}
        };
        MethodTest m = new MethodTest(Standing.class, "designationCalc", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(year, output, "Your designationCalc method does not correctly identify which year the user is in.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, String year) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message for the given year.";
        runWithInput(in, new Clause[]{
                new StringLiteral(year)
        });
    }
}
