package arrays.creating_arrays.medium.q1;

import global.BaseTest;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    private static final int length = 100;
    private static final int[] source = ArrayUtil.generateAscendingArray(0, length);

    public Clause[] testSentence(){
        return clauseBuilder();
    }

    public void runMain(){
        RandomNum.main(new String[0]);
    }

    @RepeatedTest(length)
    void printsCorrectArrayOutput(RepetitionInfo repetitionInfo){
        assertEquals(Double.parseDouble(getItemByName("rand"+(repetitionInfo.getCurrentRepetition()-1)))
                *(repetitionInfo.getCurrentRepetition()-1),
                Double.parseDouble(getItemByName("num"+(repetitionInfo.getCurrentRepetition()-1))),
                "Your program does not correctly calculate the final number on row " + repetitionInfo.getCurrentRepetition());
    }

    public Clause[] clauseBuilder(){
        Clause[] c = new Clause[length*6-1];
        int count = 0;
        for(int x = 0; x < length-1; x++){
            c[count++] = new RandomDouble(0, 1, "rand" + x);
            c[count++] = new StringLiteral(" \\* ");
            c[count++] = new IntegerLiteral(x);
            c[count++] = new StringLiteral(" = ");
            c[count++] = new DoubleLiteral("num" + x);
            c[count++] = new NewLine();
        }
        c[count++] = new RandomDouble(0, 1, "rand" + (length-1));
        c[count++] = new StringLiteral(" \\* ");
        c[count++] = new IntegerLiteral(length-1);
        c[count++] = new StringLiteral(" = ");
        c[count] = new DoubleLiteral("num" + (length-1));
        return c;
    }
}
