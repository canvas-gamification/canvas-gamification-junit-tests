package conditionals.programs_with_decision_points.medium.q5;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
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
        TestOption.defaultInput = "1 5";
        return new Clause[]{
                new StringLiteral("Enter the item you would like based on this list: "),
                new NewLine(),
                new StringLiteral("1 \\- Pepperoni Pizza"),
                new NewLine(),
                new StringLiteral("2 \\- Spaghetti Alfredo"),
                new NewLine(),
                new StringLiteral("3 \\- Panna Cotta"),
                new NewLine(),
                new StringLiteral("4 \\- Soda Can"),
                new NewLine(),
                new StringLiteral("Enter the quantity of the item you would like to purchase: "),
                new NewLine(),
                new StringLiteral("That will cost: \\$"),
                new PlaceHolder(),
                new PlaceHolder(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        MammaMia.main(new String[0]);
    }

    public static Stream<Arguments> inputProviderInvalidInput() {
        return Stream.of(Arguments.of(45, 845),
                Arguments.of(5, 7));
    }

    public static Stream<Arguments> inputProviderValidInput() {
        return Stream.of(Arguments.of(3, 6, 48), Arguments.of(1, 9, 90), Arguments.of(2, 147, 2205),
                Arguments.of(4, 18, 54), Arguments.of(1, 0, 0));
    }

    @ParameterizedTest
    @MethodSource("inputProviderValidInput")
    public void printsCorrectCost(int menuItem, int amount, int cost) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct cost for one of the items.";
        runWithInput(menuItem + " " + amount, new Clause[]{
                new IntegerLiteral(cost),
                new StringLiteral(""),
                new StringLiteral("")
        });
    }

    @ParameterizedTest
    @MethodSource("inputProviderInvalidInput")
    public void printsInvalidInputMessage(int menuItem, int amount) throws InvalidClauseException{
        TestOption.incorrectStructureErrorMessage = "Your program does not print an error message when the user inputs a number which is not on the menu.";
        runWithInput(menuItem + " " + amount, new Clause[]{
                new IntegerLiteral(0),
                new NewLine(),
                new StringLiteral("Sorry, we weren't expecting that. Please try again.")
        });
    }
}
