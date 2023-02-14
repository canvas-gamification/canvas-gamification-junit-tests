package conditionals.programs_with_decision_points.hard.q12;

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
        TestOption.defaultInput = "03/05";

        return new Clause[]{
                new StringLiteral("Enter you birthdate \\(DD\\/MM\\)\\:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    static Stream<Arguments> InputProvider() {
        return Stream.of(
                Arguments.of(22, 12, "Capricorn"),
                Arguments.of(6, 1, "Capricorn"),
                Arguments.of(19, 1, "Capricorn"),
                Arguments.of(20, 1, "Aquarius"),
                Arguments.of(4, 2, "Aquarius"),
                Arguments.of(18, 2, "Aquarius"),
                Arguments.of(19, 2, "Pisces"),
                Arguments.of(6, 3, "Pisces"),
                Arguments.of(20, 3, "Pisces"),
                Arguments.of(21, 3, "Aries"),
                Arguments.of(10, 4, "Aries"),
                Arguments.of(19, 4, "Aries"),
                Arguments.of(20, 4, "Taurus"),
                Arguments.of(30, 4, "Taurus"),
                Arguments.of(20, 5, "Taurus"),
                Arguments.of(21, 5, "Gemini"),
                Arguments.of(7, 6, "Gemini"),
                Arguments.of(21, 6, "Gemini"),
                Arguments.of(22, 6, "Cancer"),
                Arguments.of(30, 6, "Cancer"),
                Arguments.of(22, 7, "Cancer"),
                Arguments.of(23, 7, "Leo"),
                Arguments.of(24, 7, "Leo"),
                Arguments.of(22, 8, "Leo"),
                Arguments.of(23, 8, "Virgo"),
                Arguments.of(1, 9, "Virgo"),
                Arguments.of(22, 9, "Virgo"),
                Arguments.of(23, 9, "Libra"),
                Arguments.of(25, 9, "Libra"),
                Arguments.of(22, 10, "Libra"),
                Arguments.of(23, 10, "Scorpio"),
                Arguments.of(21, 11, "Scorpio"),
                Arguments.of(22, 11, "Scorpio"),
                Arguments.of(23, 11, "Sagittarius"),
                Arguments.of(6, 12, "Sagittarius"),
                Arguments.of(21, 12, "Sagittarius"),
                Arguments.of(30, 2, "Invalid date"),
                Arguments.of(-1, 2, "Invalid date"),
                Arguments.of(-1000, -10000, "Invalid date"),
                Arguments.of(30, 13, "Invalid date"),
                Arguments.of(250, 250, "Invalid date"),
                Arguments.of(2, -2, "Invalid date")
        );
    }

    public void runMain() {
        SignFromTheStars.main(new String[0]);
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void printsCorrectAstrologicalSign(int day, int month, String sign) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct star sign for the entered date.";
        runWithInput(day + "/" + month, new Clause[]{
                new StringLiteral(sign)
        });
    }
}
