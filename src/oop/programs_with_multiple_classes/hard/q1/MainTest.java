package oop.programs_with_multiple_classes.hard.q1;

import global.BaseTest;
import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;

public class MainTest extends BaseTest {
    private ObjectTest circus;
    private ObjectTest member;

    @BeforeEach
    public void Setup() {
        String circusClassString = "oop.programs_with_multiple_classes.hard.q1.Circus";
        String memberClassString = "oop.programs_with_multiple_classes.hard.q1.Member";
        circus = new ObjectTest(circusClassString);
        member = new ObjectTest(memberClassString);
    }

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Circus: Circus\\{numMembers="),
                new IntegerLiteral(100),
                new StringLiteral("\\}"),
                new NewLine(),
                new StringLiteral("Member 1: Member\\{title='"),
                new StringLiteral("Nick"),
                new StringLiteral("'\\}"),
                new NewLine(),
                new StringLiteral("Member 2: Member\\{title='"),
                new StringLiteral("Sarah"),
                new StringLiteral("'\\}"),
        };
    }

    public void runMain() {
        TestGroup.main(new String[0]);
    }
}
