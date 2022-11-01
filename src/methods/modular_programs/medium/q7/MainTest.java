package methods.modular_programs.medium.q7;

import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.params.ParameterizedTest;
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
        TestOption.defaultInput = "6";
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new PlaceHolder(),
        };
    }

    public void runMain() {
        NowThatsPerfect.main(new String[0]);
    }

    static Stream<Integer> perfectNumberProvider() {
        return Stream.of(6, 28, 496, 8128, 33550336);
    }

    static Stream<Integer> imperfectNumberProvider() {
        return Stream.of(1, 2, -1, 27, 11, 9092);
    }

    @ParameterizedTest
    @MethodSource("perfectNumberProvider")
    public void correctsPerfectNumberMethod(int n) throws Throwable {
        Object[][] arguments = {
                {n, int.class}
        };
        MethodTest m = new MethodTest(NowThatsPerfect.class, "perfectOrNot", arguments);
        Object output = m.callMethod();
        String errMsg = "Your perfectOrNot() method does not return the correct result for perfect numbers.";
        CustomAssertions._assertEquals(true, output, errMsg);
    }

    @ParameterizedTest
    @MethodSource("imperfectNumberProvider")
    public void correctsImperfectNumberMethod(int n) throws Throwable {
        Object[][] arguments = {
                {n, int.class}
        };
        MethodTest m = new MethodTest(NowThatsPerfect.class, "perfectOrNot", arguments);
        Object output = m.callMethod();
        String errMsg = "Your perfectOrNot() method does not return the correct result for imperfect numbers.";
        CustomAssertions._assertEquals(false, output, errMsg);
    }

    @ParameterizedTest
    @MethodSource("perfectNumberProvider")
    public void printsPerfectNumberCorrects(int n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message for perfect number.";
        runWithInput(n + "", new Clause[]{
                new StringLiteral("perfect"),
        });
    }

    @ParameterizedTest
    @MethodSource("imperfectNumberProvider")
    public void printsImperfectNumberCorrects(int n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message for imperfect number.";
        runWithInput(n + "", new Clause[]{
                new StringLiteral("imperfect"),
        });
    }
}
