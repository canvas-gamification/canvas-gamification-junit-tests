package methods.using_methods.hard.q5;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
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

    public void runMain(){Standing.main(new String[0]);}

    static Stream<Arguments> designationCalcInputProvider(){
        return Stream.of(Arguments.of(1, "freshmen"), Arguments.of(2, "sophomore"), Arguments.of(3, "junior"), Arguments.of(4, "senior"));
    }

    static Stream<Arguments> designationCalcInvalidInputProvider(){
        return Stream.of(Arguments.of(-1, "unknown year"), Arguments.of(5, "unknown year"));
    }

    static Stream<Arguments> mainMethodInputProvider(){
        return Stream.of(Arguments.of("1", "freshmen"), Arguments.of("2", "sophomore"), Arguments.of("3", "junior"), Arguments.of("4", "senior"));
    }

    @ParameterizedTest
    @MethodSource("designationCalcInputProvider")
    void correctDesignationCalcMethod(int in, String year) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(Standing.class, "designationCalc", new Object[]{in}, int.class);
        CustomAssertions._assertEquals(year, output, "Your designatedCalc method does not correctly identify which year the user is in.");
    }

    @ParameterizedTest
    @MethodSource("designationCalcInvalidInputProvider")
    void correctDesignationCalcInvalidInputMethod(int in, String year) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(Standing.class, "designationCalc", new Object[]{in}, int.class);
        CustomAssertions._assertEquals(year, output, "Your designatedCalc method does not correctly identify invalid input.");
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
