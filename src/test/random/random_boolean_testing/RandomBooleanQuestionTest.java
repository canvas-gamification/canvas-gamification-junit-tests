package test.random.random_boolean_testing;

import  global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomBoolean;
import global.variables.clauses.StringLiteral;

public class RandomBooleanQuestionTest extends BaseRandomTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new RandomBoolean(),
                new NewLine(),
                new StringLiteral("Next random value: "),
                new NewLine(),
                new RandomBoolean("X", "O", "name")
        };
    }

    public void runMain() {
        RandomBooleanQuestion.main(new String[0]);
    }
}
