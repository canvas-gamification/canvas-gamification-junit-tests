package arrays.creating_arrays.hard.q4;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.Logger;
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

    String[][] s = {
            {"Obi-wan", "Darth Revan", "Ashoka", "Luke", "Jaba the Hutt"},
            {"Toph", "Geralt", "Yennefer of Vengerberg", "Jaskier", "Uncle Iroh"},
            {"Spike", "Jack Sparrow", "Kenshin", "Vash", "Alphonse"},
            {" ", " ", " ", " ", " "},
            {"single", "word", "test", "input", "stuff"},
            {"Li77y", "d@rl1ng", "gr00t", "Bu55y", "M\\*x"}
    };

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Seth \n Liam \n Teresa \n Paige \n Hannah";
        return new Clause[]{
                new StringLiteral("Enter 5 names:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("At index "),
                new IntegerLiteral("index"),
                new StringLiteral(": "),
                new PlaceHolder()
        };
    }

    public void runMain(){
        RandomPickingNames.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(
                Arguments.of("Obi-wan \n Darth Revan \n Ashoka \n Luke \n Jaba the Hutt", 0),
                Arguments.of("Toph \n Geralt \n Yennefer of Vengerberg \n Jaskier \n Uncle Iroh", 1),
                Arguments.of("Spike \n Jack Sparrow \n Kenshin \n Vash \n Alphonse", 2),
                Arguments.of(" \n \n \n \n ", 3),
                Arguments.of("single \n word \n test \n input \n stuff", 4),
                Arguments.of("Li77y \n d@rl1ng \n gr00t \n Bu55y \n M\\*x", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void picksRandomNameCorrectly(String in, int c) throws InvalidClauseException {
//        runWithInput(in, new Clause[]{
//                new StringLiteral(s[c][Integer.parseInt(getItemByName("index"))])
//        });
//
        runWithInput(in);
        Logger.logMessage(getItemByName("index"));
    }
}
