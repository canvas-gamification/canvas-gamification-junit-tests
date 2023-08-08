package methods.modular_programs.medium.q6;

import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

import static global.tools.CustomAssertions._assertEquals;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "567";
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new PlaceHolder(),
        };
    }

    public void runMain() {
        Reduceros.main(new String[0]);
    }

    static Stream<Arguments> inputReducerProvider() {
        return Stream.of(
                Arguments.of(211, 4),
                Arguments.of(12, 3),
                Arguments.of(567, 9),
                Arguments.of(123, 6),
                Arguments.of(444, 3),
                Arguments.of(999, 9),
                Arguments.of(999999, 9),
                Arguments.of(0, 0));
    }

    @ParameterizedTest
    @MethodSource("inputReducerProvider")
    void printsCorrectOutputMessage(int n, int reduced) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct reducer for the given input.";
        runWithInput(n + "", new Clause[][]{{
                new IntegerLiteral(n),
                new StringLiteral("'s single number reduction is "),
                new IntegerLiteral(reduced),
        }});
    }

    @ParameterizedTest
    @MethodSource("inputReducerProvider")
    public void correctAddUpMethod(int n, int ans) throws Throwable {
        Object[][] arguments = {
                {n, int.class}
        };
        MethodTest m = new MethodTest(Reduceros.class, "addUp", arguments);
        Object output = m.callMethod();
        _assertEquals(ans, output,
                "Your addUp method does not return the correct answer.");
    }
}
