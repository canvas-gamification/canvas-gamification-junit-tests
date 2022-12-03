package methods.modular_programs.hard.q3;

import java.util.stream.Stream;

import global.MethodTest;
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
        TestOption.defaultInput = "2";
        return new Clause[]{
                new StringLiteral("Which year are you in\\? \\(1, 2 ,3, or 4\\)"),
                new NewLine(),
                new PlaceHolder(),
        };
    }

    public void runMain() {
        UniversityLife.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(1, "You're a Freshman"),
                Arguments.of(2, "You're a Sophomore"),
                Arguments.of(3, "You're a Junior"),
                Arguments.of(4, "You're a Senior"),
                Arguments.of(-1, "Invalid Input!"),
                Arguments.of(0, "Invalid Input!"),
                Arguments.of(5, "Invalid Input!"),
                Arguments.of(100, "Invalid Input!")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctUniversityYearMethod(int year, String title) throws Throwable {
        Object[][] arguments = {
                {year, int.class}
        };
        MethodTest m = new MethodTest(UniversityLife.class, "universityYear", arguments);
        Object output = m.callMethod();
        String errMsg = "Your universityYear method does not return the correct message for the given year.";
        CustomAssertions._assertEquals(title, output, errMsg);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctMainMethodOutput(int year, String title) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct output for the given year.";
        runWithInput(year + "", new Clause[]{
                new StringLiteral(title),
        });
    }
}
