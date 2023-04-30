package arrays.creating_arrays.hard.q5;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomChar;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    // Java

    static final int n = 500;

    public Clause[] testSentence() {
        return ClauseBuilder();
    }

    public void runMain() {
        AlphabetRays.main(new String[0]);
    }

    @Test
    void reversesCorrectly(){
        runMain();

        boolean b = true;
        int rev = n-1;
        for(int x = 0; x < n; x++){
            if(!getItemByName("char"+x).equals(getItemByName("reversedChar"+rev--))){
                b = false;
            }
        }

        assertTrue(b, "Your program does not correctly print the array in reverse.");
    }

    Clause[] ClauseBuilder() {
        Clause[] c = new Clause[n * 4 + 7];

        c[0] = new StringLiteral("Array of random letters:");
        c[1] = new Optional(new StringLiteral(" "));
        c[2] = new NewLine();

        int count = 3;
        for(int x = 0; x < n-1; x++){
            c[count++] = new RandomChar('a', 'z', "char" + x, true);
            c[count++] = new StringLiteral(" ");
        }
        c[count++] = new RandomChar('a', 'z', "char" + (n-1), true);
        c[count++] = new Optional(new StringLiteral(" "));
        c[count++] = new NewLine();

        c[count++] = new StringLiteral("Reversed array:");
        c[count++] = new Optional(new StringLiteral(" "));
        c[count++] = new NewLine();

        //having to use randomChar because not charLiteral
        for(int x = 0; x < n-1; x++){
            c[count++] = new RandomChar('a', 'z', "reversedChar" + x, true);
            c[count++] = new StringLiteral(" ");
        }
        c[count++] = new RandomChar('a', 'z', "reversedChar" + (n-1), true);
        c[count] = new Optional(new StringLiteral(" "));

        return c;
    }
}
