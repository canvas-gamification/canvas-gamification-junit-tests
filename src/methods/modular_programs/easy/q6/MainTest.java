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

    public void runMain(){Century.main(new String[0]);}

    static Stream<Arguments> centuryCalcInputProvider(){
        return Stream.of(Arguments.of(2000, "21st Century"), Arguments.of(2001, "21st Century"), Arguments.of(2022, "21st Century"), Arguments.of(1999, "20th Century"), Arguments.of(1998, "20th Century"), Arguments.of(1934, "20th Century"), Arguments.of(1900, "20th Century"), Arguments.of(1899, "Invalid user Year"), Arguments.of(1898, "Invalid user Year"), Arguments.of(567, "Invalid user Year"), Arguments.of(-5, "Invalid user Year"));
    }

    static Stream<Arguments> mainMethodInputProvider(){
        return Stream.of(Arguments.of("2022", "21st Century"), Arguments.of("1950", "20th Century"), Arguments.of("1265", "Invalid user Year"));
    }

    @ParameterizedTest
    @MethodSource("centuryCalcInputProvider")
    void correctCenturyCalcMethod(int in, String century) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(Century.class, "centuryCalc", new Object[]{in}, int.class);
        CustomAssertions._assertEquals(century, output, "Your centuryCalc method does not return the right century.");
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
