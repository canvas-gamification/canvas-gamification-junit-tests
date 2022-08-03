package methods.using_methods.hard.q4;

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
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "2022 1998";
        return new Clause[]{
                new StringLiteral("Please enter the current year:"),
                new NewLine(),
                new StringLiteral("Please enter the year you were born in:"),
                new NewLine(),
                new StringLiteral("Your age is "),
                new IntegerLiteral("age")
        };
    }

    public void runMain(){Using4.main(new String[0]);}

    static Stream<Arguments> ageCalcInputProvider(){
        return Stream.of(Arguments.of(9, 0, 9), Arguments.of(2031, 2000, 31), Arguments.of(1734, 1562, 172), Arguments.of(2019, 2020, -1));
    }

    static Stream<Arguments> mainMethodInputProvider(){
        return Stream.of(Arguments.of("2022 1998", 24), Arguments.of("2001 1925", 76));
    }

    @ParameterizedTest
    @MethodSource("ageCalcInputProvider")
    void correctAgeCalcMethod(int curr, int old, int age) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(Using4.class, "ageCalc", new Object[]{curr, old}, int.class, int.class);
        CustomAssertions._assertEquals(age, output, "Your ageCalc method does not properly calculate age.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, int age){
        runWithInput(in);
        assertEquals(String.valueOf(age), getItemByName("age"), "Your program does not display the correct age.");
    }
}
