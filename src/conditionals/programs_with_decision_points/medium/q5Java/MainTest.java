package conditionals.programs_with_decision_points.medium.q5Java;

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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = String.join(" ", "1", "1");
        return new Clause[]{
                new StringLiteral("Enter the item you would like based on this list:"),
                new NewLine(),
                new StringLiteral("1 - Pepperoni Pizza"),
                new NewLine(),
                new StringLiteral("2 - Spaghetti Alfredo"),
                new NewLine(),
                new StringLiteral("3 - Panna Cotta"),
                new NewLine(),
                new StringLiteral("4 - Soda Can"),
                new NewLine(),
                new StringLiteral("Enter the quantity of the item you would like to purchase:"),
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

    static Stream<Arguments> inputProviderValid() {
        return Stream.of(Arguments.of(1, 5, 50, "Pepperoni Pizza"), Arguments.of(1, 48, 480, "Pepperoni Pizza"),
                Arguments.of(3, 15, 120, "Panna Cotta"), Arguments.of(3, 4, 32, "Panna Cotta"),
                Arguments.of(4, 186, 558, "Soda Can"), Arguments.of(4, 12, 36, "Soda Can"),
                Arguments.of(2, 197, 2955, "Spaghetti Alfredo"), Arguments.of(2, 1, 15, "Spaghetti Alfredo"));
    }

    static Stream<Integer> inputProviderInvalid() {
        return Stream.of(0, 5, 147, -111);
    }

    @ParameterizedTest
    @MethodSource("inputProviderValid")
    void worksWithValidInputs(int choice, int quantity, int cost, String item) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message when given valid input.";
        runWithInput(String.join(" ", String.valueOf(choice), String.valueOf(quantity)), new Clause[]{
                new IntegerLiteral("cost"),
                new Optional(new StringLiteral("")),
                new Optional(new StringLiteral(""))
        });
        assertEquals(Integer.parseInt(getItemByName("cost")), cost, "Your program does not calculate cost correctly for " + item + ".");
    }

    @ParameterizedTest
    @MethodSource("inputProviderInvalid")
    void worksWithInvalidInputs(int choice) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print an error message when given invalid input.";
        String input = String.valueOf(choice);
        runWithInput(String.join(" ", input, input), new Clause[]{
                new IntegerLiteral("cost"),
                new NewLine(),
                new StringLiteral("Sorry, we weren't expecting that. Please try again.")
        });
        assertEquals(Integer.parseInt(getItemByName("cost")), 0, "Your program does not print out a cost of $0 when given invalid input.");
    }

}
