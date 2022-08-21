package methods.using_methods.hard.q3;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5";
        return new Clause[]{
                new StringLiteral("Please enter your favourite number: "),
                new NewLine(),
                new StringLiteral("Your favourite number is "),
                new PlaceHolder()
        };
    }

    public void runMain(){FavouriteNumber.main(new String[0]);}

    static Stream<Arguments> evenOrOddInputProvider(){
        return Stream.of(Arguments.of(0, "even"), Arguments.of(1, "odd"), Arguments.of(2, "even"), Arguments.of(-1, "odd"), Arguments.of(157932, "even"), Arguments.of(732461, "odd"), Arguments.of(-2220, "even"));
    }

    static Stream<Arguments> mainMethodInputProvider(){
        return Stream.of(Arguments.of(2, "even"), Arguments.of(1, "odd"), Arguments.of(10, "even"), Arguments.of(31, "odd"));
    }

    @ParameterizedTest
    @MethodSource("evenOrOddInputProvider")
    void correctEvenOrOddMethod(int in, String expected) throws Throwable{
        Object output = MethodUtil.invokeIfMethodExists(FavouriteNumber.class, "evenOrOdd", new Object[]{in}, int.class);
        CustomAssertions._assertEquals(expected, output, "Your evenOrOdd method does not correctly identify even or odd numbers.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(int in, String out) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct output based on the given number.";
        runWithInput(String.valueOf(in), new Clause[]{
                new StringLiteral(out)
        });
    }
}
