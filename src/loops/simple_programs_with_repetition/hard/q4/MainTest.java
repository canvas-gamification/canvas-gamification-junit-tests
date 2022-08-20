package loops.simple_programs_with_repetition.hard.q4;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "6";
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new IntegerLiteral("number"),
                new StringLiteral("'s single number reduction is "),
                new PlaceHolder()
        };
    }

    public void runMain(){ Reduceros.main(new String[0]); }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of("576", "9"), Arguments.of("0", "0"), Arguments.of("49723", "7"), Arguments.of("55", "1"), Arguments.of("-1", "invalid!"), Arguments.of("-10", "invalid!"), Arguments.of("-6785", "invalid!"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void calculatesReductionCorrectly(String in, String reduced) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not calculate the single-digit reduction properly.";
        runWithInput(in, new Clause[]{
                new StringLiteral(reduced)
        });
        assertEquals(getItemByName("number"), in, "Your program does not output the same number that was input as per the sample output.");
    }
}
