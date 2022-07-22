package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q6;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "12345" + System.lineSeparator() + "54321" + System.lineSeparator();
        return new Clause[]{
                new StringLiteral("Enter a US zip code: "),
                new NewLine(),
                new StringLiteral("Re-enter the US zip code: "),
                new NewLine(),
                new StringLiteral("The first zip code is: "),
                new IntegerLiteral("zipCode"),
                new StringLiteral(", and the second zip code is: "),
                new IntegerLiteral("zipCodeSecond")
        };
    }

    public void runMain() {ZipcodeValidator.main(new String[0]);}

    public static Stream<Arguments> inputProvider() {
    return Stream.of(Arguments.of(12345, 54321), Arguments.of(123, 123)
                , Arguments.of(35004, 35004), Arguments.of(85001, 85001)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsZipCodesCorrectly(int zipCode, int zipCodeSecond) throws InvalidClauseException {
        runWithInput(zipCode + System.lineSeparator() + zipCodeSecond);
        assertEquals(Integer.parseInt(getItemByName("zipCode")),zipCode, "Your program did not correctly print the zip codes.");
        assertEquals(Integer.parseInt(getItemByName("zipCodeSecond")),zipCodeSecond, "Your program did not correctly print the zip codes.");
    }
}
