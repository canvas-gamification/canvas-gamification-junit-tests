package methods.method_overloading.hard.q9;

import java.util.stream.Stream;

import global.MethodTest;
import global.variables.clauses.IntegerLiteral;
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
    private final String name1 = "Joe";
    private final String name2 = "Madi";
    private final int age1 = 80;
    private final int age2 = 49;

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The username for "),
                new StringLiteral(name1),
                new StringLiteral(" with the age of "),
                new IntegerLiteral(age1),
                new StringLiteral(" is: "),
                new StringLiteral(name1),
                new StringLiteral("\\."),
                new IntegerLiteral(age1),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The username for "),
                new StringLiteral(name2),
                new StringLiteral(" with the age of "),
                new IntegerLiteral(age2),
                new StringLiteral(" is: "),
                new StringLiteral(name2),
                new StringLiteral("\\."),
                new IntegerLiteral(age2),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
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
    void correctUserNameMethod1(String name, int age, String username) throws Throwable {
        Object[][] arguments = {
                {name, String.class},
                {age, int.class}
        };
        MethodTest m = new MethodTest(GenerateUsername.class, "userName", arguments);
        Object output = m.callMethod();
        String errMsg = "Your userName method does not return the correct username based on the input name and age.";
        CustomAssertions._assertEquals(username, output, errMsg);
    }

    @ParameterizedTest
    @MethodSource("inputAgeNameProvider")
    void correctUserNameMethod2(int age, String name, String username) throws Throwable {
        Object[][] arguments = {
                {age, int.class},
                {name, String.class}
        };
        MethodTest m = new MethodTest(GenerateUsername.class, "userName", arguments);
        Object output = m.callMethod();
        String errMsg = "Your userName method does not return the correct username based on the input name and age.";
        CustomAssertions._assertEquals(username, output, errMsg);
    }
}
