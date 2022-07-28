package loops.simple_programs_with_repitition.hard.q7;

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
        TestOption.defaultInput = "3bBak3rStr33t";
        return new Clause[]{
                new StringLiteral("Enter a sentence:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Result String: "),
                new PlaceHolder()
        };
    }

    public void runMain(){PushItBack.main(new String[0]);}

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of("H3ll0W0r1d", "HllWrd3001"), Arguments.of("752!~3", "!~7523"), Arguments.of("Heyo M1st3r Tw1st3r", "Heyo Mstr Twstr1313"), Arguments.of(System.lineSeparator(), ""), Arguments.of("Only words", "Only words"), Arguments.of("07", "07") );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void successfullyMovesNumbers(String in, String moved) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program did not move all numbers to the end of the string.";
        runWithInput(in, new Clause[]{
                new StringLiteral(moved)
        });
    }
}
