package arrays.referencing_array_and_its_elements.hard.q9;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseRandomTest{
    // Java

    public static final int n = 7;

    public Clause[] testSentence() {
        Clause[] c = new Clause[2 * n + 8];
        c[0] = new StringLiteral("The list of tickets are:");
        c[1] = new NewLine();
        for(int i = 2; i < 2 * n; i += 2){
            c[i] = new RandomInteger(10000, 100000, "" + ((i) / 2));
            c[i + 1] = new StringLiteral(" ");
        }
        c[2 * n] = new RandomInteger(10000, 100000,"" + n);
        c[2 * n + 1] = new Optional(new StringLiteral(" "));
        c[2 * n + 2] = new NewLine();
        c[2 * n + 3] = new StringLiteral("The winner is the ticket number ");
        c[2 * n + 4] = new RandomInteger(1, n + 1, "Index");
        c[2 * n + 5] = new StringLiteral(" with number ");
        c[2 * n + 6] = new IntegerLiteral("Ans");
        c[2 * n + 7] = new Optional(new StringLiteral("."));
        return c;
    }

    public void runMain() {
        Lottery.main(new String[0]);
    }
    @Test
    void printsCorrectOutput(){
        runMain();
        assertEquals(Integer.parseInt(getItemByName("Ans")), Integer.parseInt(getItemByName("" + (Integer.parseInt(getItemByName("Index"))))));
    }
}
