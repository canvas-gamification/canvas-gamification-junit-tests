package loops.programs_with_repetition.hard.q5;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "36";
        return new Clause[]{
                new StringLiteral("Enter a number:"),
                new NewLine(),
                new StringLiteral("Factors of "),
                new IntegerLiteral("number"),
                new StringLiteral(" that are prime numbers are:"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        PrimeFactor.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(36, new ArrayList<>(Arrays.asList(2, 3))));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsPrimeFactorsCorrectly(int number, ArrayList<Integer> factors) throws InvalidClauseException {
        Clause [][] otherName = new Clause[1][factors.size() * 2];
        int j = 0;
        for(int i = 0; i < otherName[0].length; i+= 2){
            otherName[0][i] = new IntegerLiteral(factors.get(j), "any");
            otherName[0][i + 1] = new StringLiteral(" ");
            j++;
        }
        runWithInput(String.valueOf(number), otherName);
        assertEquals(Integer.parseInt(getItemByName("number")), number, "Fail message");
    }
}
