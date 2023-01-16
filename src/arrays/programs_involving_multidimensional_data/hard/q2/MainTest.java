package arrays.programs_involving_multidimensional_data.hard.q2;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java

    static final int size = 5;

    public Clause[] testSentence() {
        return clauseBuilder();
    }

    public void runMain() {
        Swapped.main(new String[0]);
    }

    @RepeatedTest(5)
    void correctMainMethodOutput() {
        runMain();

        for (int x = 0; x < size; x++) {
            assertEquals(Integer.parseInt(getItemByName("1r" + x + "c0")), Integer.parseInt(getItemByName("2r" + x + "c" + (size - 1))), "Your program does not move the first element of a row to the last element.");
            assertEquals(Integer.parseInt(getItemByName("1r" + x + "c" + (size - 1))), Integer.parseInt(getItemByName("2r" + x + "c0")), "Your program does not move the last element of a row to the first element.");
        }
    }

    Clause[] clauseBuilder() {
        Clause[] c = new Clause[(size * size * 2 + size) * 2 + 1];

        int count = 0;

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                c[count++] = new RandomInteger(0, 101, "1r" + x + "c" + y);
                c[count++] = new StringLiteral(" ");
            }
            c[count++] = new NewLine();
        }

        c[count++] = new NewLine();

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                c[count++] = new RandomInteger(0, 101, "2r" + x + "c" + y);
                c[count++] = new StringLiteral(" ");
            }
            c[count++] = new NewLine();
        }

        return c;
    }
}
