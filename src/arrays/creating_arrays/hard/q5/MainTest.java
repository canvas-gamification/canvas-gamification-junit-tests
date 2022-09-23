package arrays.creating_arrays.hard.q5;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        return ClauseBuilder();
    }

    public void runMain(){
        AlphabetRays.main(new String[0]);
    }

    Clause[] ClauseBuilder(){
        Clause[] c = new Clause[51];

        String[] s = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
        "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        int count = 0;
        for(int x = 0; x < 25; x++){
            c[count++] = new StringLiteral(s[x]);
            c[count++] = new NewLine();
        }
        c[count] = new StringLiteral(s[25]);

        return c;
    }
}
