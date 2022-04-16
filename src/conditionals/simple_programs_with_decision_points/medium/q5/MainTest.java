package conditionals.simple_programs_with_decision_points.medium.q5;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "12000.0";
        return new Clause[]{
                new StringLiteral("What is your annual salary in \\$\\?"),
                new NewLine(),
                new PlaceHolder(),
                new PlaceHolder(),
                new StringLiteral("Annual Salary\\: \\$"),
                new DoubleLiteral("salary")
        };
    }

    public void runMain() {
        LuckyEmp.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(10000.0, true, "Congratulations!, you received a bonus of 15%!", 11500.0),
                Arguments.of(12000.0, false, "", 12000.0), Arguments.of(550.50, true, "Congratulations!, you received a bonus of 15%!", 633.075),
                Arguments.of(50755.96, false, "", 50755.96)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(double input, boolean bonus, String message, double outputSalary) throws InvalidClauseException {
        runWithInput(input + "", new Clause[]{
                new StringLiteral(message),
                bonus ? new NewLine() : new StringLiteral("")
        });
        assertEquals(Double.parseDouble(getItemByName("salary")), outputSalary, 0.01, "The calculated salary value is incorrect.");
    }
}
