package methods.method_overloading.medium.q3;

import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Hello I am "),
                new NewLine(),
                new StringLiteral("Hello I am bob")
        };
    }

    public void runMain() {
        ThreeStrings.main(new String[0]);
    }

    static Stream<Arguments> inputTwoStringsProvider() {
        return Stream.of(
                Arguments.of("Hello", " I am ", "Hello I am "),
                Arguments.of("Hello", " the world is ending", "Hello the world is ending"),
                Arguments.of("Hello ", "World!", "Hello World!"),
                Arguments.of(" ", " ", "  "),
                Arguments.of("", "", ""));
    }

    static Stream<Arguments> inputThreeStringsProvider() {
        return Stream.of(
                Arguments.of("Hello", " I am ", "bob", "Hello I am bob"),
                Arguments.of("Hello", " I am", "", "Hello I am"),
                Arguments.of("Goodbye", "", "Seth", "GoodbyeSeth"),
                Arguments.of("I am", " ", "rob", "I am rob"),
                Arguments.of("", "I am", " bob", "I am bob"),
                Arguments.of("", "", "", ""),
                Arguments.of(" ", " ", " ", "   "));
    }

    @ParameterizedTest
    @MethodSource("inputTwoStringsProvider")
    void correctTwoStringMethod(String s1, String s2, String result) throws Throwable {
        Object[][] arguments = {
                {s1, String.class},
                {s2, String.class}
        };
        MethodTest m = new MethodTest(ThreeStrings.class, "concatenate", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(output, result, "Your concatenate method does not correctly concatenate two strings.");
    }

    @ParameterizedTest
    @MethodSource("inputThreeStringsProvider")
    void correctThreeStringMethod(String s1, String s2, String s3, String result) throws Throwable {
        Object[][] arguments = {
                {s1, String.class},
                {s2, String.class},
                {s3, String.class}
        };
        MethodTest m = new MethodTest(ThreeStrings.class, "concatenate", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(output, result, "Your concatenate method does not correctly concatenate three strings.");
    }
}
