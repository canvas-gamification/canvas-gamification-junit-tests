package methods.modular_programs.hard.q10;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    @Override
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "2012";
        return new Clause[]{
                new StringLiteral("Enter a year:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The Chinese zodiac sign for the year "),
                new IntegerLiteral(),
                new StringLiteral(" is "),
                new PlaceHolder(),
                new StringLiteral(".")
        };
    }

    @Override
    public void runMain() {
        GoatYear.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(1960, "Rat"),
                Arguments.of(1972, "Rat"),
                Arguments.of(1985, "Ox"),
                Arguments.of(2033, "Ox"),
                Arguments.of(1962, "Tiger"),
                Arguments.of(1950, "Tiger"),
                Arguments.of(1951, "Rabbit"),
                Arguments.of(1963, "Rabbit"),
                Arguments.of(2024, "Dragon"),
                Arguments.of(2012, "Dragon"),
                Arguments.of(2001, "Snake"),
                Arguments.of(1641, "Snake"),
                Arguments.of(1978, "Horse"),
                Arguments.of(778, "Horse"),
                Arguments.of(1955, "Goat"),
                Arguments.of(95, "Goat"),
                Arguments.of(2004, "Monkey"),
                Arguments.of(2016, "Monkey"),
                Arguments.of(1573, "Rooster"),
                Arguments.of(1981, "Rooster"),
                Arguments.of(14, "Dog"),
                Arguments.of(1994, "Dog"),
                Arguments.of(1959, "Pig"),
                Arguments.of(603, "Pig")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsCorrectChineseZodiacSign(int year, String sign) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct chinese zodiac sign for the entered year.";
        runWithInput(String.valueOf(year), new Clause[]{
                new StringLiteral(sign)
        });
    }

}
