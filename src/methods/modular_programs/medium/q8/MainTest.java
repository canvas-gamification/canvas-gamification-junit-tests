package methods.modular_programs.medium.q8;

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
        TestOption.defaultInput = " Hello There ";
        return new Clause[]{
                new StringLiteral("Enter a sentence: "),
                new NewLine(),
                new PlaceHolder(),
        };
    }

    public void runMain() {
        QueryStr.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(" Hello There ", "%20%Hello%20%There%20%"),
                Arguments.of(" ", "%20%"),
                Arguments.of("World", "World"),
                Arguments.of("The sun will come up tomorrow", "The%20%sun%20%will%20%come%20%up%20%tomorrow"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctCleanUpMethod(String originalStr, String cleanedUpStr) throws Throwable {
        Object[][] arguments = {
                {originalStr, String.class}
        };
        MethodTest m = new MethodTest(QueryStr.class, "cleanUp", arguments);
        Object output = m.callMethod();
        String errMsg = "Your cleanUp method does not correctly modify and return the query string.";
        CustomAssertions._assertEquals(cleanedUpStr, output, errMsg);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctMainMethodOutput(String originalStr, String cleanedUpStr) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the modified query string.";
        runWithInput(originalStr, new Clause[][]{{
                new StringLiteral("The new query string is: "),
                new StringLiteral(cleanedUpStr),
        }});
    }
}
