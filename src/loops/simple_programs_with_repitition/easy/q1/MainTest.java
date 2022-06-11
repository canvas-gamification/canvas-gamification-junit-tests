package loops.simple_programs_with_repitition.easy.q1;

import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Hello there" + System.lineSeparator() + 1;
        return new Clause[]{
                new StringLiteral("Enter a sentence: "),
                new NewLine(),
                new StringLiteral("Enter the number of times to repeat the sentence: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        PunishmentLoop.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("Hello there.", 10),
                Arguments.of("So do all who live to see such times, but that is not for them to decide. All we have to decide is what to do with the time that is given to us.", 7),
                Arguments.of("Never gonna give you up.", 0), Arguments.of("Never gonna let you down.", 1), Arguments.of("Never gonna run around and desert you.", -1));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsSentenceCorrectNumberOfTimes(String sentence, int n) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the input sentence n times.";
        runWithInput(sentence + System.lineSeparator() + n, sentenceRepetition(sentence, n));
    }

    Clause[][] sentenceRepetition(String sentence, int n) {
        if (n < 1)
            return new Clause[][]{{new StringLiteral("")}};
        Clause[][] c = new Clause[1][n * 2];
        for (int i = 0; i < c[0].length; i += 2) {
            c[0][i] = new StringLiteral(sentence);
            c[0][i + 1] = new NewLine();
        }
        return c;
    }

}
