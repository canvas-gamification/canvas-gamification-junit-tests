package loops.for_loops.hard.q5;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
    // Parsons
    private static final int sequenceLength = 10;

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Fibonacci Sequence: "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        FiboWhat.main(new String[0]);
    }

    private static int[] getFibSequence() {
        int[] arr = new int[sequenceLength];
        int n1 = 0;
        int n2 = 1;
        arr[0] = n1;
        arr[1] = n2;
        for (int i = 2; i < arr.length; i++) {
            int temp = n1 + n2;
            arr[i] = temp;
            n1 = n2;
            n2 = temp;
        }
        return arr;
    }

    private Clause[][] clauseBuilder(int[] numbersInSequence) {
        int n = sequenceLength * 2;
        Clause[][] c = new Clause[1][n];
        for (int i = 0; i < n; i += 2) {
            c[0][i] = new IntegerLiteral(numbersInSequence[i / 2]);
            c[0][i + 1] = new StringLiteral(", ");
        }
        return c;
    }

    @Test
    void outputsFibonacciSequenceTermsCorrectly() throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print out the specified number of terms of the Fibonacci sequence.";
        runWithInput("", clauseBuilder(getFibSequence()));
    }
}
