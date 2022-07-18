package loops.programs_with_repetition.hard.q6;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
        return Stream.of(Arguments.of("Hello Tallulah like the lovely weather", "l", "8"), Arguments.of("IIii aaa", "i", "4"), Arguments.of(" ", " ", "1"), Arguments.of("!!!! dumdundundun !!!!!!", "!", "10"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void countsMostUsedCharacterCorrectly(String in, String letter, String num) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify the most common character.";
        Clause[][] place = new Clause[1][3];
        place[0][0] = new StringLiteral(letter);
        place[0][1] = new StringLiteral(" ");
        place[0][2] = new IntegerLiteral("num");
        runWithInput(in, place);
        assertEquals(num, getItemByName("num"), "Your program does not correctly count the instances of the most common character.");
    }
}
