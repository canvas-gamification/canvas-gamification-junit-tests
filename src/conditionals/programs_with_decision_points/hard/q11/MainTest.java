package conditionals.programs_with_decision_points.hard.q11;

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

    private static final int currentDay = 27;
    private static final int currentMonth = 9;
    private static final int diff = 45;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "12 11";
        return new Clause[]{
                new StringLiteral("Enter your birth day:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter your birth month as a number:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };

    }

    public void runMain() {
        Discount.main(new String[0]);
    }

    public static boolean calcAns(int birthDay, int birthMonth) {
        int cd = (currentDay) + (currentMonth - 1) * 30;
        int bd = (birthDay) + (birthMonth - 1) * 30;
        if (Math.min(Math.abs(cd - bd), Math.min(Math.abs((cd - 360) - bd), Math.abs((cd + 360) - bd))) <= diff)
            return true;
        return false;
    }

    static Stream<Arguments> InputProvider() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(30, 12),
                Arguments.of(2, 1),
                Arguments.of(2, 3),
                Arguments.of(1, 1, 2015),
                Arguments.of(30, 12, 2015),
                Arguments.of(2, 1, 2015),
                Arguments.of(2, 30, 2015),
                Arguments.of(currentDay, currentMonth),
                Arguments.of(1, currentMonth),
                Arguments.of(30, currentMonth),
                Arguments.of((currentDay + diff) % 30, (currentMonth + diff / 30) % 12),
                Arguments.of((currentDay + diff + 1) % 30, (currentMonth + diff / 30) % 12),
                Arguments.of((currentDay - diff + 30) % 30, (currentMonth - diff / 30 + 12) % 12),
                Arguments.of((currentDay - diff - 1 + 30) % 30, (currentMonth - diff / 30 + 12) % 12)
        );
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void identifiesDiscountCorrectly(int a, int b) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program did not correctly identify if the user qualifies for the discount.";
        if (calcAns(a, b)) {
            runWithInput(a + " " + b, new Clause[]{
                    new StringLiteral("You qualify for a 10% discount!")});
        } else {
            runWithInput(a + " " + b, new Clause[]{
                    new StringLiteral("You do not qualify for any discounts.")});
        }
    }
}
