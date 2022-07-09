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


public class MainTest extends BaseTest {
    // Parson's with Distractors
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "12345" + System.lineSeparator() + "54321" + System.lineSeparator();
        return new Clause[]{
                new StringLiteral("Enter a US zip code: "),
                new NewLine(),
                new StringLiteral("Re-enter the US zip code: "),
                new NewLine(),
                new StringLiteral("The first zip code is: "),
                new PlaceHolder(),
                new StringLiteral(", and the second zip code is: "),
                new PlaceHolder()
        };
    }

    public void runMain() {ZipcodeValidator.main(new String[0]);}

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("12345", "54321"), Arguments.of("123", "123")
                , Arguments.of("35004", "35004"), Arguments.of("85001", "85001")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void validZipcodeValidator(String zipCode, String zipCodeSecond) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program did not correctly printed the zip codes.";
        runWithInput( zipCode + System.lineSeparator() + zipCodeSecond + System.lineSeparator(), new Clause[]{
                new StringLiteral(zipCode),
                new StringLiteral(zipCodeSecond)
                });
    }
}
