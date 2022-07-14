package loops.while_loops.hard.q8;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    //Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "39";
        return new Clause[]{
                new StringLiteral("Enter a sentence"),
                new NewLine(),
                new StringLiteral("Total number of Characters in the sentence: "),
                new IntegerLiteral("number")
        };
    }

    public void runMain() {CounterChar.main(new String[0]);}

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of("    ", 0), Arguments.of("hello world", 10), Arguments.of("You Know ThAt MOST OTHER character counters Count spaceS", 48), Arguments.of("10",2));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void countsCorrectly(String in, int num){
        runWithInput(in);
        assertEquals(Integer.parseInt(getItemByName("number")), num, "Your program is not correctly counting the number of characters.");
    }

}
