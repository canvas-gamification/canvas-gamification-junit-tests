package loops.for_loops.hard.q5;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Fibonacci Sequence: "),
                new IntegerLiteral(0),
                new StringLiteral(", "),
                new IntegerLiteral(1),
                new StringLiteral(", "),
                new IntegerLiteral(1),
                new StringLiteral(", "),
                new IntegerLiteral(3),
                new StringLiteral(", "),
                new IntegerLiteral(6),
                new StringLiteral(", "),
                new IntegerLiteral(12),
                new StringLiteral(", "),
                new IntegerLiteral(24),
                new StringLiteral(", "),
                new IntegerLiteral(48),
                new StringLiteral(", "),
                new IntegerLiteral(96),
                new StringLiteral(", "),
                new IntegerLiteral(192),
                new StringLiteral(", ")
        };
    }

    public void runMain() {
        FiboWhat.main(new String[0]);
    }
}
