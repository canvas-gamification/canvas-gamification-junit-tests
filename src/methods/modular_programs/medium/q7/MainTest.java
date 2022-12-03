package methods.modular_programs.medium.q7;

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

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(6, true),
                Arguments.of(28, true),
                Arguments.of(496, true),
                Arguments.of(8128, true),
                Arguments.of(33550336, true),
                Arguments.of(1, false),
                Arguments.of(2, false),
                Arguments.of(-1, false),
                Arguments.of(27, false),
                Arguments.of(11, false),
                Arguments.of(9092, false)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctsPerfectOrNotMethod(int n, boolean b) throws Throwable {
        Object[][] arguments = {
                {n, int.class}
        };
        MethodTest m = new MethodTest(NowThatsPerfect.class, "perfectOrNot", arguments);
        Object output = m.callMethod();
        String errMsg = "Your perfectOrNot method does not correctly identify perfect numbers.";
        CustomAssertions._assertEquals(b, output, errMsg);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsPerfectNumberCorrects(int n, boolean b) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print if a number is perfect.";
        String s;
        if(b)
            s = "perfect";
        else
            s = "imperfect";
        runWithInput(n + "", new Clause[]{
                new StringLiteral(s),
        });
    }
}
