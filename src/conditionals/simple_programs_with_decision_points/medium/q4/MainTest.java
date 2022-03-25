package conditionals.simple_programs_with_decision_points.medium.q4;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "20 40";
        return new Clause[]{
                new StringLiteral("Enter the first number: "),
                new NewLine(),
                new StringLiteral("Enter the second number: "),
                new NewLine(),
                new StringLiteral("a = "),
                new Optional(new StringLiteral("-", "negativeA")),
                new IntegerLiteral("a"),
                new StringLiteral(", b = "),
                new Optional(new StringLiteral("-", "negativeB")),
                new IntegerLiteral("b")
        };
    }

    public void runMain() {
        TheBiggerInt.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(-20, -40, 20, -40), Arguments.of(49, 10, 39, 10), Arguments.of(20, 50, 20, 50), Arguments.of(500, 0, 500, 0), Arguments.of(-40, -20, -40, -20));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void inputTest(int inputA, int inputB, int outputA, int outputB){
        runWithInput(inputA + System.lineSeparator() + inputB);
        assertEquals(Integer.parseInt((isNull(getItemAtIndex(6))? "" : "-") + getItemByName("a")), outputA, "Calculated value of A is incorrect. Make sure a = a - b if a > b");
        assertEquals(Integer.parseInt((isNull(getItemAtIndex(9))? "" : "-") + getItemByName("b")), outputB, "Calculated value of B is incorrect.");
    }
}
