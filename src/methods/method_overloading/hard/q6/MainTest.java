package methods.method_overloading.hard.q6;

import java.util.stream.Stream;

import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.PlaceHolder;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Jack Swift\nJack.Swift\n38471";
        return new Clause[]{
                new StringLiteral("Please enter a student's name:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Please enter a username:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Please enter a student number:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder(),
                new StringLiteral(" is a valid username: "),
                new PlaceHolder(),
                new NewLine(),
                new IntegerLiteral("studentNum"),
                new StringLiteral(" is a valid student number: "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        AttendingStudent.main(new String[0]);
    }

    static Stream<Arguments> studentNumberProvider() {
        return Stream.of(
                Arguments.of(12345678, true),
                Arguments.of(51927731, true),
                Arguments.of(981237091, true),
                Arguments.of(10000000, true),
                Arguments.of(0, false),
                Arguments.of(-1, false),
                Arguments.of(100, false),
                Arguments.of(999, false),
                Arguments.of(6484831, false),
                Arguments.of(9999999, false),
                Arguments.of(00000001, false),
                Arguments.of(100000000, true)
        );
    }

    static Stream<Arguments> studentNameProvider() {
        return Stream.of(
                Arguments.of("John", "Smith", "John.Smith", true),
                Arguments.of("Jack", "Swift", "Jack.Swift", true),
                Arguments.of("Ben", "Doe", "Ben.Doe", true),
                Arguments.of("123", "456", "123.456", true),
                Arguments.of("Hello", "World", "Hello.World", true),
                Arguments.of(" ", " ", " . ", true),
                Arguments.of(" ", "123", " .12", false),
                Arguments.of("Jack", "Swift", "jackSwift151", false),
                Arguments.of("Hello", "World", "Hello.World!", false),
                Arguments.of("Hello", "World", "Hello World", false),
                Arguments.of("Hello", "World", "HelloWorld", false)
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of("Jackie Piper", "Jackie.Piper", "938156724", true, true),
                Arguments.of("Wendy Brandon", "W3ndy.Brandon", "543219876", false, true),
                Arguments.of("Hershal Bling", "Hershal.Bling", "8", true, false),
                Arguments.of("Mindy Maze", "MindyMaze123", "57839", false, false)
        );
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    public void correctMainMethodOutput(String name, String username, String num, boolean validName, boolean validNum) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify valid usernames and student numbers.";
        runWithInput(name + "\n" + username + "\n" + num, new Clause[]{
                new StringLiteral(username),
                new StringLiteral(String.valueOf(validName)),
                new StringLiteral(String.valueOf(validNum))
        });
        assertEquals(Integer.parseInt(num), Integer.parseInt(getItemByName("studentNum")), "Your program does not print the input student number.");
    }

    @ParameterizedTest
    @MethodSource("studentNumberProvider")
    public void correctStudentCheckMethod(int studentID, boolean result) throws Throwable {
        Object[][] arguments = {
                {studentID, int.class}
        };
        MethodTest m = new MethodTest(AttendingStudent.class, "studentCheck", arguments);
        Object output = m.callMethod();
        String errMsg = "Your studentCheck method does not correctly check if a student number is valid.";
        CustomAssertions._assertEquals(result, output, errMsg);
    }

    @ParameterizedTest
    @MethodSource("studentNameProvider")
    public void correctStudentCheckMethod(String fname, String lname, String username, boolean result) throws Throwable {
        Object[][] arguments = {
                {fname, String.class},
                {lname, String.class},
                {username, String.class}
        };
        MethodTest m = new MethodTest(AttendingStudent.class, "studentCheck", arguments);
        Object output = m.callMethod();
        String errMsg = "Your studentCheck method does not correctly check if a username is valid.";
        CustomAssertions._assertEquals(result, output, errMsg);
    }
}
