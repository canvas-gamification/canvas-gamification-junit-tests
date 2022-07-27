package pre_defined_classes.simple_programs_taking_string_user_input.medium.q2;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
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
        TestOption.defaultInput = "Kelowna";
        return new Clause[]{
                new StringLiteral("Enter a city name: "),
                new NewLine(),
                new StringLiteral("What is the name of the city that is spelt like "),
                new PlaceHolder(),
                new StringLiteral("\\?")
        };
    }

    public void runMain() {
        GuessCityName.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("Kelowna", "Kylywny"), Arguments.of("Medicine Hat", "Mydycyny Hyt"),
                Arguments.of("Munich", "Mynych"), Arguments.of("Viewhill", "Vyywhyll"), Arguments.of(" ", " "),
                Arguments.of(System.lineSeparator(), ""));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void replacesVowelsCorrectly(String city, String city2) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly replace all the vowels in the city name.";
        runWithInput(city, new Clause[]{
                new StringLiteral(city2)
        });
    }

}
