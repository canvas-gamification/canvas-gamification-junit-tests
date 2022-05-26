package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q5;

import global.BaseTest;
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
        TestOption.defaultInput = "85 ";
        return new Clause[]{
                new StringLiteral("Enter your grade in percentage: "),
                new StringLiteral("Your GPA is: "),
                new DoubleLiteral("gpa")
        };
    }

    public void runMain() {
        LetterCalculator.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(95, 3.75), Arguments.of(50, 1.5), Arguments.of(69, 2.45), Arguments.of(76, 2.80), Arguments.of(100, 4.0));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void calculatesGPACorrectly(int grade, double gpa){
        runWithInput(grade + System.lineSeparator());
        assertEquals(Double.parseDouble(getItemByName("gpa")), gpa, "Your program does not calculate GPA correctly.");
    }
}
