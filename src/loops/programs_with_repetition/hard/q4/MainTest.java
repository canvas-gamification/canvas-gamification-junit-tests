package loops.programs_with_repetition.hard.q4;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Do not panic, this is a test";
        return new Clause[]{
                new StringLiteral("Enter a sentence:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder(),
                new Optional(new StringLiteral(" "))
        };
    }

    public void runMain(){ArtificialSelection.main(new String[0]);}

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of("warning, they are coming to find you", ",gninraw they era coming ot find uoy"),
                Arguments.of("hello", "olleh"), Arguments.of("if i put a bunch of palindromes in here it would print out the same thing, wouldn't that be so pointless", "fi i tup a hcnub of semordnilap in ereh it dluow print tuo the emas thing, t'ndluow that eb so sseltniop "),
                Arguments.of("There's A Storm Still COMING", "s'erehT A mrotS Still GNIMOC "), Arguments.of("23,000 leagues under the sea", "000,32 leagues rednu the aes "));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void reversesEveryOtherCorrectly(String in, String reversed) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly reverse every other word.";
        runWithInput(in, new Clause[]{
                new StringLiteral(reversed)
        });
    }

    @Test
    void handlesSpecialCharacters() throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly handle special characters.";
        runWithInput("!~!! !~!~!~~ ~~~~!!!", new Clause[]{
                new StringLiteral("!!~! !~!~!~~ !!!~~~~")
        });
    }
}
