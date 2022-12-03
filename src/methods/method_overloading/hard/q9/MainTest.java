package methods.method_overloading.hard.q9;

import java.util.stream.Stream;

import global.MethodTest;
import global.tools.TestOption;
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

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Susanna Mary \n 13 81";
        return new Clause[]{
                new StringLiteral("Enter two names:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter corresponding ages:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        GenerateUsername.main(new String[0]);
    }

    static Stream<Arguments> inputNameAgeProvider() {
        return Stream.of(
                Arguments.of("Matt", 24, "Matt.24"),
                Arguments.of(" ", 0, " .0"),
                Arguments.of("K", -1, "K.-1"),
                Arguments.of("", 1001, ".1001"),
                Arguments.of("Helen", 92, "Helen.92"));
    }

    static Stream<Arguments> inputAgeNameProvider() {
        return Stream.of(
                Arguments.of(24, "Matt", "Matt.24"),
                Arguments.of(0, " ", " .0"),
                Arguments.of(-1, "K", "K.-1"),
                Arguments.of(1001, "", ".1001"),
                Arguments.of(92, "Helen", "Helen.92"));
    }

    @ParameterizedTest
    @MethodSource("inputNameAgeProvider")
    void correctUserNameMethod(String name, int age, String username) throws Throwable {
        Object[][] arguments = {
                {name, String.class},
                {age, int.class}
        };
        MethodTest m = new MethodTest(GenerateUsername.class, "userName", arguments);
        Object output = m.callMethod();
        String errMsg = "Your userName method does not format the username correctly when given the name and age.";
        CustomAssertions._assertEquals(username, output, errMsg);
    }

    @ParameterizedTest
    @MethodSource("inputAgeNameProvider")
    void correctUserNameMethod(int age, String name, String username) throws Throwable {
        Object[][] arguments = {
                {age, int.class},
                {name, String.class}
        };
        MethodTest m = new MethodTest(GenerateUsername.class, "userName", arguments);
        Object output = m.callMethod();
        String errMsg = "Your userName method does not format the username correctly when given the age and name.";
        CustomAssertions._assertEquals(username, output, errMsg);
    }
}
