package pre_defined_classes.simple_programs_taking_string_user_input.medium.q3;

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
        TestOption.defaultInput = "COSC-111 COSC-121";
        return new Clause[]{
                new StringLiteral("Enter the name of the first course: "),
                new NewLine(),
                new StringLiteral("Enter the name of the second course: "),
                new NewLine(),
                new StringLiteral("The courses are: "),
                new PlaceHolder(),
                new StringLiteral(" and "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        CourseNames.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("COSC-111", "COSC-121"), Arguments.of("testCourse", "stillATestCourse"),
                Arguments.of("introductoryComputerScience", "advancedComputerScience"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsCoursesCorrectly(String course1, String course2) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the two course names.";
        runWithInput(course1 + System.lineSeparator() + course2, new Clause[]{
                new StringLiteral(course1, "course1"),
                new StringLiteral(course2, "course2")
        });
    }
}
