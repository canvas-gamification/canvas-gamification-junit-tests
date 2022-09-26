package arrays.arrays_with_methods.medium.q9;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new IntegerLiteral(24),
                new StringLiteral(" "),
                new IntegerLiteral(120),
                new StringLiteral(" "),
                new IntegerLiteral(720),
                new StringLiteral(" "),
                new NewLine(),
                new IntegerLiteral(2),
                new StringLiteral(" "),
                new IntegerLiteral(1),
                new StringLiteral(" "),
                new IntegerLiteral(2),
                new StringLiteral(" "),
                new NewLine(),
                new IntegerLiteral(6),
                new StringLiteral(" "),
                new IntegerLiteral(6),
                new StringLiteral(" "),
                new IntegerLiteral(40320),
                new StringLiteral(" ")
        };
    }

    public void runMain() {
        TwoDAndThatsAFact.main(new String[0]);
    }

    static Stream<Arguments> factInputProvider() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 6),
                Arguments.of(4, 24),
                Arguments.of(5, 120),
                Arguments.of(6, 720),
                Arguments.of(7, 5040),
                Arguments.of(8, 40320),
                Arguments.of(9, 362880),
                Arguments.of(10, 3628800),
                Arguments.of(11, 39916800)
        );
    }

    @ParameterizedTest
    @MethodSource("factInputProvider")
    void correctFactMethod(int n, int fact) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(TwoDAndThatsAFact.class, "fact", new Object[]{n}, int.class);
        CustomAssertions._assertEquals(fact, output, "Your fact method does not correctly calculate factorials.");
    }
}
