package loops.simple_programs_with_repitition.hard.q6;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = " Hello Darkness My old friend ";
        return new Clause[]{
                new StringLiteral("Enter a sentence:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The new query string is: "),
                new PlaceHolder()
        };
    }

    public void runMain(){QueryStr.main(new String[0]);}

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(" hello darkness  my old friend ", "%20%hello%20%darkness%20%%20%my%20%old%20%friend%20%"), Arguments.of("I'mAtAPayphone", "I'mAtAPayphone"), Arguments.of("   ", "%20%%20%%20%"), Arguments.of(System.lineSeparator(), ""));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctlyReplacesSpaces(String in, String replaced) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly replace all spaces with %20%.";
        runWithInput(in, new Clause[]{
                new StringLiteral(replaced)
        });
    }
}
