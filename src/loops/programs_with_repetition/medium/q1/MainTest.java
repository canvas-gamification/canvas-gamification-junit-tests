package loops.programs_with_repetition.medium.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("    \\*"),
                new NewLine(),
                new StringLiteral("   \\*\\*"),
                new NewLine(),
                new StringLiteral("  \\*\\*\\*"),
                new NewLine(),
                new StringLiteral(" \\*\\*\\*\\*"),
                new NewLine(),
                new StringLiteral("\\*\\*\\*\\*\\*"),
                new NewLine(),
                new StringLiteral(" \\*\\*\\*\\*"),
                new NewLine(),
                new StringLiteral("  \\*\\*\\*"),
                new NewLine(),
                new StringLiteral("   \\*\\*"),
                new NewLine(),
                new StringLiteral("    \\*")
        };
    }

    public void runMain() {
        DiamondCantBreak.main(new String[0]);
    }
}
