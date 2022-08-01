package methods.modular_programs.easy.q2;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "39";
        return new Clause[]{
                new StringLiteral("Please enter your favourite integer: "),
                new NewLine(),
                new PlaceHolder(),
                new NewLine(),
                new StringLiteral("Your number multiplied by PI is: "),
                new DoubleLiteral("multiply")
        };
    }

    public void runMain() {
        FavInteger.main(new String[0]);
    }

    static Stream<Arguments> isEvenInputProvider() {
        return Stream.of(
                Arguments.of(0, true), Arguments.of(2, true), Arguments.of(-1, false), Arguments.of(1, false),
                Arguments.of(39, false), Arguments.of(105, false), Arguments.of(-768, true)
        );
    }

    static Stream<Arguments> multiplyInputProvider() {
        return Stream.of(
                Arguments.of(0, 0.0),
                Arguments.of(2, 6.283185307179586),
                Arguments.of(147, 461.8141200776996),
                Arguments.of(-1, -3.141592653589793),
                Arguments.of(-3496, -10983.007916949917)
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of(0, 0.0, "Your favourite integer is even. "),
                Arguments.of(2, 6.283185307179586, "Your favourite integer is even\\. "),
                Arguments.of(147, 461.8141200776996, "Your favourite integer is odd\\. "),
                Arguments.of(-1, -3.141592653589793, "Your favourite integer is odd\\. "),
                Arguments.of(-3496, -10983.007916949917, "Your favourite integer is even\\. ")
        );
    }

    @ParameterizedTest
    @MethodSource("isEvenInputProvider")
    void correctIsEvenMethod(int input, boolean isEven) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(FavInteger.class, "isEven", new Object[]{input},
                int.class);
        CustomAssertions._assertEquals(isEven, output, "Your isEven method does not correctly identify if a number is even.");
    }

    @ParameterizedTest
    @MethodSource("multiplyInputProvider")
    void correctMultiplyMethod(int input, double multiply) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(FavInteger.class, "multiply", new Object[]{input},
                int.class);
        CustomAssertions._assertEquals(multiply, output, 0.0000001, "Your multiply method does not correctly multiply the number by the specified value.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(int input, double multiply, String message) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message if the number is even or odd.";
        runWithInput(String.valueOf(input), new Clause[]{
                new StringLiteral(message)
        });
        assertEquals(multiply, Double.parseDouble(getItemByName("multiply")), 0.000001, "Your program does not correctly output the number multiplied by the specified value.");
    }
}
