package arrays.creating_arrays.medium.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons

    private static final int length = 100;
    private static final int subtract = 1, add = 0; //swap two numbers for a starting multiplication of 1

    public Clause[] testSentence() {
        return clauseBuilder();
    }

    public void runMain() {
        RandomNum.main(new String[0]);
    }

    @RepeatedTest(length)
    void printsCorrectArrayOutput(RepetitionInfo repetitionInfo) {
        double expected = Double.parseDouble(getItemByName("rand" + (repetitionInfo.getCurrentRepetition() - 1)))
                * (repetitionInfo.getCurrentRepetition() - subtract);
        double actual = Double.parseDouble(getItemByName("num" + (repetitionInfo.getCurrentRepetition() - 1)));
        assertEquals(expected, actual, 0.00001, "Your program does not correctly calculate the random value by the index");
    }

    public Clause[] clauseBuilder() {
        Clause[] c = new Clause[length * 6 - 1];
        int count = 0;
        for (int x = 0; x < length - 1; x++) {
            c[count++] = new RandomDouble(0, 1, "rand" + x);
            c[count++] = new StringLiteral(" \\* ");
            c[count++] = new IntegerLiteral(x + add);
            c[count++] = new StringLiteral(" = ");
            c[count++] = new DoubleLiteral("num" + x);
            c[count++] = new NewLine();
        }
        c[count++] = new RandomDouble(0, 1, "rand" + (length - 1));
        c[count++] = new StringLiteral(" \\* ");
        c[count++] = new IntegerLiteral(length - 1 + add);
        c[count++] = new StringLiteral(" = ");
        c[count] = new DoubleLiteral("num" + (length - 1));
        return c;
    }
}
