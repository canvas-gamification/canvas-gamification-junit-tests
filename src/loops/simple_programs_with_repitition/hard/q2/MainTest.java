package loops.simple_programs_with_repitition.hard.q2;

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
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Sheep";
        return new Clause[]{
                new StringLiteral("Enter a word to be converted:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        Jvaiava.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of("Sheep", "Sepava"), Arguments.of("Latin", "Ltnava"),
                Arguments.of("Java", "Jvava"), Arguments.of("leute", "lueava"), Arguments.of("0", "0ava"),
                Arguments.of("test", "tsava"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void convertsWordsCorrectly(String inputWord, String wordTranslation) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly convert the input word to Java Latin.";
        runWithInput(inputWord, new Clause[]{
                new StringLiteral(inputWord + " in Java Latin is " + wordTranslation)
        });
    }
}
