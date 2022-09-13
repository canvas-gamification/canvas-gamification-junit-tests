package methods.modular_programs.easy.q6;

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
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "2012";
        return new Clause[]{
                new StringLiteral("Please enter the year you were born in: "),
                new NewLine(),
                new StringLiteral("You're from the "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        Century.main(new String[0]);
    }

    static Stream<Arguments> centuryCalcInputProvider() {
        return Stream.of(
                Arguments.of(2000, "21st Century"),
                Arguments.of(2001, "21st Century"),
                Arguments.of(2022, "21st Century"),
                Arguments.of(1999, "20th Century"),
                Arguments.of(1998, "20th Century"),
                Arguments.of(1934, "20th Century"),
                Arguments.of(1900, "20th Century"),
                Arguments.of(1899, "19th Century"),
                Arguments.of(1898, "19th Century"),
                Arguments.of(1800, "19th Century"),
                Arguments.of(1799, "18th Century"),
                Arguments.of(1798, "18th Century"),
                Arguments.of(1700, "18th Century"),
                Arguments.of(1699, "17th Century"),
                Arguments.of(1698, "17th Century"),
                Arguments.of(1600, "17th Century"),
                Arguments.of(1599, "16th Century"),
                Arguments.of(1598, "16th Century"),
                Arguments.of(1500, "16th Century"),
                Arguments.of(1499, "Unknown Century"),
                Arguments.of(1498, "Unknown Century"),
                Arguments.of(567, "Unknown Century"),
                Arguments.of(-5, "Unknown Century"));
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of("2022", "21st Century"),
                Arguments.of("1950", "20th Century"),
                Arguments.of("1830", "19th Century"),
                Arguments.of("1782", "18th Century"),
                Arguments.of("1634", "17th Century"),
                Arguments.of("1555", "16th Century"),
                Arguments.of("1265", "Unknown Century"));
    }

    @ParameterizedTest
    @MethodSource("centuryCalcInputProvider")
    void correctCenturyCalcMethod(int in, String century) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(Century.class, "centuryCalc", new Object[]{in}, int.class);
        CustomAssertions._assertEquals(century, output, "Your centuryCalc method does not return the correct century.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, String century) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct century.";
        runWithInput(in, new Clause[]{
                new StringLiteral(century)
        });
    }
}
