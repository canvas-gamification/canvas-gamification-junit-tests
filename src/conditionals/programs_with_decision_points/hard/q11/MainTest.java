package conditionals.programs_with_decision_points.hard.q11;

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
    // Java

    private static final int currentDay = 27;
    private static final int currentMonth = 9;
    private static final int currentYear = 2022;
    private static final int diff = 45;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "12 11 2022";
        return new Clause[]{
                new StringLiteral("Enter your birth day: "),
                new NewLine(),
                new StringLiteral("Enter your birth month as a number: "),
                new NewLine(),
                new StringLiteral("Enter the year of your most recent birthday: "),
                new NewLine(),
                new PlaceHolder()
        };

    }

    public void runMain() {
        Discount.main(new String[0]);
    }

    public static boolean calcAns(int birthDay, int birthMonth, int birthYear) {
        int difference = Math.abs(((birthYear - currentYear) * 365) + ((birthMonth - currentMonth) * 30) + birthDay - currentDay);
        if (difference <= diff)
            return true;
        else
            return false;
    }

    static Stream<Arguments> InputProvider() {
        return Stream.of(
                Arguments.of(1, 1, currentYear),
                Arguments.of(30, 12, currentYear),
                Arguments.of(2, 1, currentYear),
                Arguments.of(2, 30, currentYear),
                Arguments.of(1, 1, 2015),
                Arguments.of(30, 12, 2015),
                Arguments.of(2, 1, 2015),
                Arguments.of(2, 30, 2015),
                Arguments.of(currentDay, currentMonth, currentYear),
                Arguments.of(1, currentMonth, currentYear),
                Arguments.of(30, currentMonth, currentYear),
                Arguments.of((currentDay + diff) % 30, (currentMonth + diff / 30) % 12, (currentYear + diff / 365)),
                Arguments.of((currentDay + diff + 1) % 30, (currentMonth + diff / 30) % 12, (currentYear + diff / 365)),
                Arguments.of((currentDay - diff + 30) % 30, (currentMonth - diff / 30 + 12) % 12, (currentYear - diff / 365 + 365)),
                Arguments.of((currentDay - diff - 1 + 30) % 30, (currentMonth - diff / 30 + 12) % 12, (currentYear - diff / 365 + 365))
        );
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void identifiesDiscountCorrectly(int a, int b, int c) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program did not correctly identify the qualification for the discount.";
        if (calcAns(a, b, c)) {
            runWithInput(a + " " + b + " " + c, new Clause[]{
                    new StringLiteral("You qualify for a 10% discount!")});
        } else {
            runWithInput(a + " " + b + " " + c, new Clause[]{
                    new StringLiteral("You do not qualify for any discounts.")});
        }
    }
}
