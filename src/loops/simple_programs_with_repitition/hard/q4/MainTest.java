package loops.simple_programs_with_repitition.hard.q4;

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
    //Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "6";
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new IntegerLiteral("number"),
                new StringLiteral("'s single number reduction is "),
                new IntegerLiteral("reduction")
        };
    }

    public void runMain(){ Reduceros.main(new String[0]); }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of("576", "9"), Arguments.of("0", "0"), Arguments.of("49723", "7"), Arguments.of("55", "1"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void calculatedReductionCorrectly(String in, String reduced){
        runWithInput(in);
        assertEquals(getItemByName("number"), in, "Your program does not output the same number that was input as per the sample output.");
        assertEquals(getItemByName("reduction"), reduced, "Your program does not calculated the reduction properly.");
    }
}
