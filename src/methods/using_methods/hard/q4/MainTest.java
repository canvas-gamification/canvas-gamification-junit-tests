package methods.using_methods.hard.q4;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
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
    // Parsons
    public Clause[] testSentence() {
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

    public void runMain() {
        HowOld.main(new String[0]);
    }

    static Stream<Arguments> ageCalcInputProvider() {
        return Stream.of(Arguments.of(9, 0, 9), Arguments.of(2031, 2000, 31), Arguments.of(1734, 1562, 172));
    }

    static Stream<Arguments> ageCalcInvalidInputProvider() {
        return Stream.of(Arguments.of(2019, 2020), Arguments.of(2017, 2020), Arguments.of(1999, 2078), Arguments.of(145, -743));
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(Arguments.of("2022 1998", 24), Arguments.of("2001 1925", 76), Arguments.of("2015 2022", -1));
    }

    @ParameterizedTest
    @MethodSource("ageCalcInputProvider")
    void correctAgeCalcMethod(int curr, int old, int age) throws Throwable {
        Object[][] arguments = {
                {curr, int.class},
                {old, int.class}
        };
        MethodTest m = new MethodTest(HowOld.class, "ageCalc", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(age, output, "Your ageCalc method does not properly calculate age.");
    }

    @ParameterizedTest
    @MethodSource("ageCalcInvalidInputProvider")
    void ageCalcIdentifiesInvalidInput(int tooOld, int tooNew) throws Throwable {
        Object[][] arguments = {
                {tooOld, int.class},
                {tooNew, int.class}
        };
        MethodTest m = new MethodTest(HowOld.class, "ageCalc", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(-1, output, "Your ageCalc method does not correctly identify invalid input.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, int age) {
        runWithInput(in);
        assertEquals(age, Integer.parseInt(getItemByName("age")), "Your program does not display the correct age.");
    }
}
