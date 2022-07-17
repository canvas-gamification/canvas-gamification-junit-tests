package loops.programs_with_repetition.hard.q6;

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
        TestOption.defaultInput = "how could this happen to meeeeeee";
        return new Clause[]{
                new StringLiteral("Enter a sentence:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain(){KingOfTheString.main(new String[0]);}

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of("Hello Tallulah like the lovely weather", "l 8"), Arguments.of("IIii aaa", "i 4"), Arguments.of(" ", "  1"), Arguments.of("!!!! dumdundundun !!!!!!", "! 10"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void countsMostUsedCharacterCorrectly(String in, String count) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify and count the most common character.";
        runWithInput(in, new Clause[]{
                new StringLiteral(count)
        });
    }
}
