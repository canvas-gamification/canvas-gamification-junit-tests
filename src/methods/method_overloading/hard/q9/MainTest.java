package methods.method_overloading.hard.q9;

import java.util.stream.Stream;

import global.tools.TestOption;
import global.variables.clauses.PlaceHolder;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Susanna Mary 13 81";
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
    void userNameWithNameAgeCorrect(String name, int age, String username) throws Throwable {
        String errMsg = "Your method \"userName()\" does not give the correct username.";
        Object output = MethodUtil.invokeIfMethodExists(GenerateUsername.class, "userName", new Object[]{name, age},
                String.class, int.class);
        CustomAssertions._assertEquals(output, username, errMsg);
    }

    @ParameterizedTest
    @MethodSource("inputAgeNameProvider")
    void userNameWithAgeNameCorrect(int age, String name, String username) throws Throwable {
        String errMsg = "Your method \"userName()\" does not give the correct username.";
        Object output = MethodUtil.invokeIfMethodExists(GenerateUsername.class, "userName", new Object[]{age, name},
                int.class, String.class);
        CustomAssertions._assertEquals(output, username, errMsg);
    }
}
