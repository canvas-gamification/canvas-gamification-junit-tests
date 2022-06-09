package loops.simple_programs_with_repitition.easy.q1;

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

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of("Hello there.", 10),
                Arguments.of("So do all who live to see such times, but that is not for them to decide. All we have to decide is what to do with the time that is given to us.", 7),
                Arguments.of("Among us", 0), Arguments.of("Never gonna give you up.", 1), Arguments.of("This should not work.", -1));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsSentenceCorrectNumberOfTimes(String sentence, int n){

    }

    Clause[][] sentenceRepetition(int n){
        return null;
    }

}
