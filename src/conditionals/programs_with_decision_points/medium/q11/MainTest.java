package conditionals.programs_with_decision_points.medium.q11;
import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        // when you need to provide Scanner input
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1";

        return new Clause[]{
                new StringLiteral("Enter a weather condition \\(1-5\\):"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    static Stream<Arguments> InputProvider() {
        return Stream.of(
                Arguments.of("1", "sunny"),
                Arguments.of("2", "cloudy"),
                Arguments.of("3", "rainy"),
                Arguments.of("4", "stormy"),
                Arguments.of("5", "snowy"),
                Arguments.of("6", "Invalid\\. Please enter a number between 1 and 5\\.")
        );
    }

    public void runMain() {
        WeatherConditions.main(new String[0]);
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void printsCorrectWeather(String num, String weather) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct weather for the entered number.";
        runWithInput(num, new Clause[]{
                new StringLiteral(weather)
        });
    }
}

