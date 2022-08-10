package methods.defining_methods.medium.q3;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
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
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "39";
        return new Clause[]{
                new StringLiteral("Please enter a sentence: "),
                new NewLine(),
                new StringLiteral("The length of your sentence is: "),
                new IntegerLiteral("length")
        };
    }

    public void runMain(){LengthOfTheString.main(new String[0]);}

    static Stream<Arguments> stringLenCalcInputProvider(){
        return Stream.of(Arguments.of("help", 4), Arguments.of("now with spaces", 15), Arguments.of("CAPITAL IDEA", 12), Arguments.of("s     p     a     c    e", 24), Arguments.of("~hi!", 4), Arguments.of("!-~-!", 5), Arguments.of("", 0));
    }

    static Stream<Arguments> mainMethodInputProvider(){
        return Stream.of(Arguments.of("seventy bottles of student's tears on the wall", 46), Arguments.of(System.lineSeparator(), 0), Arguments.of("aa", 2));
    }

    @ParameterizedTest
    @MethodSource("stringLenCalcInputProvider")
    void correctStringLenCalcMethod(String in, int length) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(LengthOfTheString.class, "stringLenCalc", new Object[]{in}, String.class);
        CustomAssertions._assertEquals(length, output, "Your stringLenCalc method does not correctly count the length of the string.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, int length){
        runWithInput(in);
        assertEquals(length, Integer.parseInt(getItemByName("length")), "Your program does not display the correct sentence length.");
    }
}
