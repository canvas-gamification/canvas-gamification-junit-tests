package arrays.creating_arrays.medium.q2;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z")
        };
    }

    public void runMain(){
        RandomNum.main(new String[0]);
    }
}
