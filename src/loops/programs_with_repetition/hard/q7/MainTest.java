package loops.programs_with_repetition.hard.q7;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "3.14";
        return new Clause[]{
                new StringLiteral("Enter a number to approximate:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Approximation of sin\\("),
                new DoubleLiteral("x"),
                new StringLiteral("\\) using n = "),
                new IntegerLiteral(10),
                new StringLiteral(" is "),
                new DoubleLiteral("approx")
        };
    }

    public void runMain(){SinOfTheTimes.main(new String[0]);}

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(2.56, "0.5493554364272203"), Arguments.of(1.07, "0.8772005042746817"), Arguments.of(4.2, "-0.8715757642927082"), Arguments.of(24, "1.052000954450763E9"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctApproximationCalculated(double in, String approx){
        runWithInput(String.valueOf(in));
        assertEquals(approx, getItemByName("approx"), "Your approximation of sin(x) is incorrect.");
    }
}
