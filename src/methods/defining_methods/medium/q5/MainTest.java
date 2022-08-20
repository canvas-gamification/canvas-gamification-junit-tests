package methods.defining_methods.medium.q5;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
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
        TestOption.defaultInput = "false";
        return new Clause[]{
                new StringLiteral("Enter a boolean: "),
                new NewLine(),
                new StringLiteral("The inverse value of the given boolean variable is: "),
                new PlaceHolder()
        };
    }

    public void runMain(){InverseMethod.main(new String[0]);}

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(true, "false"), Arguments.of(false, "true"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctInverseCalcMethod(boolean b, String s) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(InverseMethod.class, "inverseCalc", new Object[]{b}, boolean.class);
        CustomAssertions._assertEquals(!b, output, "Your inverseCalc method does not invert the input boolean.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsOutputCorrectly(boolean b, String s) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not display the correct boolean.";
        runWithInput(String.valueOf(b), new Clause[]{
                new StringLiteral(s)
        });
    }
}
