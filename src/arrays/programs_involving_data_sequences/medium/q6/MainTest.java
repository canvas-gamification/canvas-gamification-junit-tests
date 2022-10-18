package arrays.programs_involving_data_sequences.medium.q6;

import global.BaseTest;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new IntegerLiteral(2),
                new NewLine(),
                new IntegerLiteral(6),
                new NewLine(),
                new IntegerLiteral(10),
                new NewLine(),
                new IntegerLiteral(14),
                new NewLine(),
                new IntegerLiteral(18),
                new NewLine(),
                new IntegerLiteral(22),
                new NewLine(),
                new IntegerLiteral(44),
                new NewLine(),
                new IntegerLiteral(12)
        };
    }

    public void runMain(){
        MultiThing.main(new String[0]);
    }

    static Stream<Arguments> multiplierInputProvider(){
        return Stream.of(
                Arguments.of(ArrayUtil.generateRandomArray(0, 100, 20))
        );
    }
}
