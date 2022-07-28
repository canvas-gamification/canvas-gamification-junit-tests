package loops.simple_programs_with_repitition.hard.q5;

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
        TestOption.defaultInput = "6";
        return new Clause[]{
                new StringLiteral("Enter a number:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain(){ NowThatsPerfect.main(new String[0]); }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of("6", "6 is a Perfect Number!"), Arguments.of("7", "7 is NOT a Perfect Number!"), Arguments.of("-3", "-3 is NOT a Perfect Number!"), Arguments.of("0", "0 is NOT a Perfect Number!"), Arguments.of("33550336", "33550336 is a Perfect Number!", Arguments.of("546", "546 is NOT a Perfect Number!"), Arguments.of("8128", "8128 is a Perfect Number!"), Arguments.of("-6", "-6 is NOT a Perfect Number!")));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void identifiesPerfectNumbersCorrectly(String in, String place) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify perfect numbers.";
        runWithInput(in, new Clause[]{
                new StringLiteral(place)
        });
    }
}
