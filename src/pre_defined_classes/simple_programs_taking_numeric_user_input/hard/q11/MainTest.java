package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q11;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {


    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "10 7.0";
        return new Clause[]{
                new StringLiteral("Enter how many marks the exam is out of: "),
                new NewLine(),
                new StringLiteral("Enter your score on the exam: "),
                new NewLine(),
                new StringLiteral("Your scored a "),
                new DoubleLiteral("ans"),
                new StringLiteral("% on the exam!")
        };
    }

    public void runMain() {
        Bonus.main(new String[0]);
    }
    @ParameterizedTest
    @MethodSource("calculatesGradeCorrectlyInputProvider")
    public void calculatesGradeCorrectly(int x, double y, double answer){
        runWithInput(x + " " + y);
        assertEquals(answer,Double.parseDouble(getItemByName("ans")), "You did not correctly calculate the" +
                " score of the student's grade.");
    }

    public static Stream<Arguments> calculatesGradeCorrectlyInputProvider(){
        return Stream.of(
                Arguments.of(10, 7.0, 80.0),
                Arguments.of(80, 35.8, 54.75),
                Arguments.of(5, 53.84, 1086.8)
        );
    }
}
