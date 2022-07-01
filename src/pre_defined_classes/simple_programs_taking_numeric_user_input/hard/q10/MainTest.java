package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q10;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1200 6 ";
        return new Clause[]{
                new StringLiteral("Enter your salary: "),
                new NewLine(),
                new StringLiteral("Enter years of service:" ),
                new NewLine(),
                new StringLiteral("Your increased salary is " ),
                new DoubleLiteral("newSalary")
        };
    }

    public void runMain() {
        NewSalaryCalculator.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(1200, 6, 1560.0));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void calculatesGPACorrectly(double salary, int years, double newSalary) throws InvalidClauseException {
        runWithInput(salary + " " + years);
        assertEquals(Double.parseDouble(getItemByName("newSalary")), newSalary);
    }
}

