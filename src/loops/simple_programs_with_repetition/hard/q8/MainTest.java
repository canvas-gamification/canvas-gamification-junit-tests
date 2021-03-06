package loops.simple_programs_with_repetition.hard.q8;

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
        TestOption.defaultInput = "HowCouldThisHappen";
        return new Clause[]{
                new StringLiteral("Enter a sentence:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Socially Distanced String: "),
                new PlaceHolder()
        };
    }

    public void runMain(){VirtualSocialDistancing.main(new String[0]);}

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of("ByTalos", "By Talos"), Arguments.of("SCREAM", "S C R E A M"), Arguments.of("nothing", "nothing"), Arguments.of("W3lpIDone", "W3lp I Done"), Arguments.of("Mu~ch!Excitement!ManyWow!", "Mu~ch! Excitement! Many Wow!"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctlySeparatesString(String in, String seperated) throws InvalidClauseException{
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly separate a string by capital letters.";
        runWithInput(in, new Clause[]{
                new StringLiteral(seperated)
        });
    }

    @Test
    void readsInputCorrectly() throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program should only accept input without any spaces.";
        runWithInput("What Happens Here?", new Clause[]{
                new StringLiteral("What")
        });
    }
}
